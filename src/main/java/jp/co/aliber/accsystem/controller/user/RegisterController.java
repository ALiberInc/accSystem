package jp.co.aliber.accsystem.controller.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.form.user.RegisterForm;
import jp.co.aliber.accsystem.service.user.RegisterService;

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
	private RegisterService registerService;

	@Autowired
	MessageSource messages;

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
	 * 初期表示
	 *
	 * @param form
	 *            アカウントの作成用form
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(RegisterForm form) {

		return "register";
	}

	/**
	 * 登録処理
	 *
	 * @param form
	 *            アカウントの作成用form
	 * @param result
	 *            Resultバンディング
	 * @return
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String save(@Validated RegisterForm form, BindingResult result) {
		// 入力チェック
		if (!validate(form, result)) {
			return "register";
		}
		TLoginUser loginUser = new TLoginUser();
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

		registerService.regist(loginUser);

		return "redirect:/finish?forwardURL=login";
	}

	/**
	 * 入力チェック
	 *
	 * @param BindingResult<br>
	 *            Resultバンディング
	 * @return validateResult<br>
	 *         入力チェック結果
	 */
	private boolean validate(RegisterForm form, BindingResult result) {

		boolean validateResult = true;

		// 入力チェック
		if (result.hasErrors()) {
			validateResult = false;
		}

		// ログインIDの重複チェック
		if (StringUtils.isNotEmpty(form.getLoginId())) {
			if (registerService.checkIfLoginIdExist(form.getLoginId())) {
				result.rejectValue("loginId", "error.duplicated",
						new Object[] { messages.getMessage("registerForm.loginId", null, null) }, "");
				validateResult = false;
			}
		}

		// メールの重複チェック
		if (StringUtils.isNotEmpty(form.getEmail())) {
			if (registerService.checkIfEmailExist(form.getEmail())) {
				result.rejectValue("email", "error.duplicated",
						new Object[] { messages.getMessage("registerForm.email", null, null) }, "");
				validateResult = false;
			}
		}

		// 入力チェック結果
		return validateResult;
	}
}