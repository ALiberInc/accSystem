package jp.co.aliber.accsystem.controller.salary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.form.salary.SendMailForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.UtilService;
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;
import jp.co.aliber.accsystem.service.employee.TEmployeeService;
import net.sf.jasperreports.engine.JRException;

/**
 * メール送信画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/send_mail")
public class SendMailController {

	@Autowired
	JavaMailSender sender;

	/**
	 * 從業員情報サービス
	 */
	@Autowired
	TEmployeeService tEmployeeService;

	@Autowired
	CompanyBasicInfoService companyBasicInfoService;

	@Autowired
	UtilService utilService;

	/**
	 * データのバンディング
	 *
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * メール送信画面
	 *
	 * @param locale
	 * @param model
	 * @param form
	 *            メール送信画面FORM
	 * @param sendMailStr
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(SendMailForm form, @RequestParam(value = "sendMailStr", required = true) String sendMailStr,
			@RequestParam(value = "yearMonth", required = true) String yearMonth,
			@AuthenticationPrincipal LoginUser loginUser) {
		form.setSendMailStr(sendMailStr);
		// 年数
		form.setSalaryYear(yearMonth.substring(0, 4));
		// 平成年数
		int thisYear = Integer.valueOf(yearMonth.substring(0, 4)) - 1988;
		// 月
		form.setSalaryMonth(yearMonth.substring(4, 6));
		// 件名
		String mailName = "平成" + thisYear + "年" + yearMonth.substring(4, 6) + "月" + "支給の給与明細書につきまして";
		form.setMailName(mailName);

		// 会社情報
		// 会社番号よって情報を取得
		TCompany tcompany = companyBasicInfoService.searchComp(loginUser.getUser().getCompId());
		// 会社名
		form.setCompName(tcompany.getCompName());
		// 会社アドレース
		form.setCompAddress(tcompany.getCompAdd1() + (tcompany.getCompAdd2() != null ? tcompany.getCompAdd2() : ""));
		// 会社電話
		form.setCompTel(tcompany.getCompTel1() + "-" + tcompany.getCompTel2() + "-" + tcompany.getCompTel3());
		return "salary/send_mail";
	}

	/**
	 * @param form
	 *            メール送信画面FORM
	 * @param forName
	 *            送信者名
	 * @param bodyType
	 *            手動/自動入力フラグ
	 * @param body1
	 *            本文1
	 * @param body2
	 *            本文2
	 * @param sendMailStr
	 *            送信先 メールアドレス
	 * @param loginUser
	 *            ログインユーザ
	 * @return
	 */
	@RequestMapping(value = { "/send" }, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String send(SendMailForm form, @RequestParam(value = "forName") String forName,
			@RequestParam(value = "bodyType") String bodyType, @RequestParam(value = "body1") String body1,
			@RequestParam(value = "body2") String body2, @RequestParam(value = "sendMailStr") String sendMailStr,
			@AuthenticationPrincipal LoginUser loginUser) {
		// 返却結果
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String[] sendMails = sendMailStr.split(",");
			// メール送信
			for (String sendMail : sendMails) {

				TEmployee tEmployee = tEmployeeService.getTEmployee(Integer.valueOf(sendMail),
						loginUser.getUser().getCompId());

				// メールを生成する
				MimeMessage message = produceMail(form, forName, bodyType, tEmployee, body1, body2);

				this.sender.send(message);
			}
			// 成功の場合
			resultMap.put("result_cd", ImmutableValues.FLG_OFF);
		} catch (Exception e) {
			// 失敗の場合
			// result_cdをセットする
			resultMap.put("result_cd", ImmutableValues.FLG_ON);
		}
		// 返却
		String result = JSONValue.toJSONString(resultMap);

		return result;

	}

	/**
	 * @param form
	 * @param forName
	 * @param bodyType
	 * @param tEmployee
	 * @return
	 * @throws MessagingException
	 */
	private MimeMessage produceMail(SendMailForm form, String forName, String bodyType, TEmployee tEmployee,
			String body1, String body2) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		// 添付ファイルを用いる場合は、tureを設定します
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		// 送信者名をセットする
		helper.setFrom(forName + "<accsystem@aliber.co.jp>");
		// メールアドレスをセットする
		helper.setTo(tEmployee.getMailAddress());
		// 件名をセットする
		helper.setSubject(form.getMailName());
		// 本文
		StringBuilder textBuilder = new StringBuilder(tEmployee.getLastName());

		// 自動入力の場合
		if (bodyType.equals("0")) {
			// 本文をセットする
			textBuilder.append(tEmployee.getFirstName()).append("　様").append("\n\n").append(form.getCompName())
					.append("です。").append("\n\n").append("明細書をお送りします。").append("\n\n")
					.append("添付ファイルをクリックして、内容をご確認ください。").append("\n\n").append("以上の内容について覚えがない場合は").append("\n")
					.append("下記の連絡先まで、お問い合わせください。\nよろしくお願いいたします。\n------------------------------------------------------------\n")
					.append(form.getCompAddress()).append("\n").append(form.getCompName()).append("\n")
					.append(form.getCompTel());
		} else {
			// 手動入力の場合
			textBuilder.append(tEmployee.getFirstName()).append("　様").append("\n\n").append(body1).append("\n\n")
					.append(form.getCompName()).append("です。").append("\n\n").append("明細書をお送りします。").append("\n\n")
					.append("添付ファイルをクリックして、内容をご確認ください。").append("\n\n").append(body2);
		}

		helper.setText(textBuilder.toString());

		// 件名
		String attachmentName = "給与明細書" + form.getMailName().substring(0, 8) + ".pdf";
		// 内容

		try (ByteArrayOutputStream pdfOutputStream = utilService.creationPdfOutputStream(tEmployee.getEmployeeId(),
				tEmployee.getCompId(), form.getSalaryYear() + form.getSalaryMonth())) {
			helper.addAttachment(attachmentName, new ByteArrayResource(pdfOutputStream.toByteArray()));
		} catch (JRException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return message;
	}
}
