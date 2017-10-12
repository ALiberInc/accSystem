package jp.co.aliber.accsystem.controller;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.form.LoginUserInfoForm;
import jp.co.aliber.accsystem.service.SignUpService;

/**
 * アカウントの作成controller
 *
 * @author yu_k
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	/**
	 * アカウントの作成サービス
	 */
	@Autowired
	private SignUpService signUpService;

	/**
	 * メッセージ設定
	 */
	@Autowired
	private MessageSource messages;


	/**
	 * データのバンディング
	 *
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class,
				new StringTrimmerEditor(true));
	}


	/**
	 * 初期表示
	 *
	 * @param locale
	 *            ロケ－ル
	 * @param model
	 *            モデル
	 * @param form
	 *            アカウントの作成用form
	 * @return
	 */
	@RequestMapping(value = {"/", "" }, method = RequestMethod.GET)
	public String index(Model model, LoginUserInfoForm form) {

		return "register";
	}


	/**
	 * 登録処理
	 *
	 * @param locale
	 *            ロケ－ル
	 * @param model
	 *            モデル
	 * @param form
	 *            アカウントの作成用form
	 * @param result
	 *            Resultバンディング
	 * @return
	 */
	@RequestMapping(value = {"/save" }, method = RequestMethod.POST)
	public String save(Model model,
			@Validated  LoginUserInfoForm form,
			BindingResult result) {
		Locale locale = new Locale("ja", "JP");
		// 入力チェック
		if (!validate(locale, model, form, result)) {
			return "register";
		}
		TLoginUser loginUser = new TLoginUser();
		// 会社番号
		loginUser.setCompId(Integer.valueOf(form.getCompId()));
		// 姓
		loginUser.setLastName(form.getLastName());
		// 名
		loginUser.setFirstName(form.getFirstName());
		// 姓カナ
		if (StringUtils.isNotEmpty(form.getLastNameKana())) {
			loginUser.setLastNameKana(form.getLastNameKana());
		}
		// 名カナ
		if (StringUtils.isNotEmpty(form.getFirstNameKana())) {
			loginUser.setFirstNameKana(form.getFirstNameKana());
		}
		// アルファベット名
		if (StringUtils.isNotEmpty(form.getAlphabetName())) {
			loginUser.setAlphabetName(form.getAlphabetName());
		}
		// メールアドレス
		loginUser.setEmail(form.getEmail());
		// ユーザ名
		loginUser.setLoginId(form.getLoginId());
		// 暗証番号
		loginUser.setPassword(form.getPassword());

		signUpService.regist(loginUser);

		return "login";
	}


	/**
	 * 入力チェック
	 *
	 * @param locale<br>
	 *            ロケール
	 * @param model<br>
	 *            モデル
	 * @param LoginuserinfoeditForm<br>
	 *            ログイン者情報編集Form
	 * @param BindingResult<br>
	 *            Resultバンディング
	 * @return validateResult<br>
	 *         入力チェック結果
	 */
	private boolean validate(Locale locale, Model model, LoginUserInfoForm form,
			BindingResult result) {

		boolean validateResult = true;

		// 入力チェック
		if (result.hasErrors()) {
			model.addAttribute("validationError", messages
					.getMessage("validation.error.message", null, locale));
			validateResult = false;
		}
		// 入力チェック結果
		return validateResult;
	}
}
