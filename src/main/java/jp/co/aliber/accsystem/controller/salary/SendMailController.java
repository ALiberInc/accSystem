package jp.co.aliber.accsystem.controller.salary;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;
import jp.co.aliber.accsystem.service.employee.TEmployeeService;

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
	private MailSender sender;

	/**
	 * 從業員情報サービス
	 */
	@Autowired
	private TEmployeeService tEmployeeService;

	@Autowired
	private CompanyBasicInfoService companyBasicInfoService;

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
	public String index(Locale locale, Model model, SendMailForm form,
			@RequestParam(value = "sendMailStr", required = true) String sendMailStr,
			@RequestParam(value = "yearMonth", required = true) String yearMonth,
			@AuthenticationPrincipal LoginUser loginUser) {
		form.setSendMailStr(sendMailStr);
		// 件名
		// 平成年数
		int thisYear = Integer.valueOf(yearMonth.substring(0, 4)) - 1988;
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

				SimpleMailMessage msg = new SimpleMailMessage();
				// 送信者名をセットする
				msg.setFrom(forName + "<accsystem@aliber.co.jp>");
				// メールアドレスをセットする
				msg.setTo(tEmployee.getMailAddress());
				// 件名をセットする
				msg.setSubject(form.getMailName());
				// 本文
				StringBuilder textBuilder = new StringBuilder(tEmployee.getLastName());
				// 自動入力の場合
				// 手動入力の場合の実装はまだです
				if (bodyType.equals("0")) {
					// 本文をセットする
					textBuilder.append(tEmployee.getFirstName()).append("　様").append("\n\n").append(form.getCompName())
							.append("です。").append("\n\n").append("明細書をお送りします。").append("\n\n")
							.append("以下のURLをクリックして、内容をご確認ください。").append("\n")
							.append("http://localhost:8080/accsystem/print?employeeId=").append("\n\n")
							.append("※有効期限：本日より7日間").append("\n\n").append("以上の内容について覚えがない場合は").append("\n")
							.append("下記の連絡先まで、お問い合わせください。\nよろしくお願いいたします。\n------------------------------------------------------------\n")
							.append(form.getCompAddress()).append("\n").append(form.getCompName()).append("\n")
							.append(form.getCompTel());
				}
				msg.setText(textBuilder.toString());
				this.sender.send(msg);
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
}
