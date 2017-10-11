package jp.co.aliber.accsystem.controller.user;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.form.user.LoginForm;

/**
 * ログイン画面
 *
 * @author zhong_zengqiang
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * データのバンディング
	 *
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = { "/ ", "" }, method = RequestMethod.GET)
	public String index() {

		return "/login";
	}

	/**
	 * ログイン処理
	 *
	 */
	@RequestMapping(value = { "/submit" }, method = RequestMethod.POST)
	public String login(LoginForm form) {
		System.out.println();
		return "top_menu";
	}

}
