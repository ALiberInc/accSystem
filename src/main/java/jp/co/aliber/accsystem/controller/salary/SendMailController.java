package jp.co.aliber.accsystem.controller.salary;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.form.salary.SendMailFrom;
import jp.co.aliber.accsystem.service.TEmployeeService;

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
	public String index(Locale locale, Model model, SendMailFrom form,
			@RequestParam(value = "sendMailStr", required = false) String sendMailStr) {
		form.setSendMailStr(sendMailStr);
		return "_salary/send_mail";
	}

	/**
	 * 送信ボタン
	 *
	 * @param locale
	 * @param model
	 * @param form
	 *            メール送信画面FORM
	 * @param forName
	 *            送信者名
	 * @param bodyType
	 *            作成方法
	 * @param subject
	 *            件名
	 * @param body1
	 *            本文1
	 * @param body2
	 *            本文2
	 * @param sendMailStr
	 *            メールアドレス
	 * @return
	 */
	@RequestMapping(value = { "/send" }, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String send(Locale locale, Model model, SendMailFrom form, @RequestParam(value = "forName") String forName,
			@RequestParam(value = "bodyType") String bodyType, @RequestParam(value = "subject") String subject,
			@RequestParam(value = "body1") String body1, @RequestParam(value = "body2") String body2,
			@RequestParam(value = "sendMailStr") String sendMailStr) {

		// 返却結果
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String[] sendMails = sendMailStr.split(",");
			// メール送信
			for (String sendMail : sendMails) {

				TEmployee tEmployee = tEmployeeService.getTEmployee(Integer.valueOf(sendMail), 1);

				SimpleMailMessage msg = new SimpleMailMessage();
				// 送信者名をセットする
				msg.setFrom(forName);
				// メールアドレスをセットする
				msg.setTo(tEmployee.getMailAddress());
				// 件名をセットする
				msg.setSubject(subject);
				// 本文をセットする
				msg.setText(body1 + body2);
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
