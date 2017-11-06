package jp.co.aliber.accsystem.controller.common;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.form.common.MessageForm;

@Controller
@RequestMapping("/message")
public class MessageController {

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
	 * 処理完了画面
	 *
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(MessageForm form) {
		return "message";
	}
}
