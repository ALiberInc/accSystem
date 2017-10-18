package jp.co.aliber.accsystem.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/finish")
public class FinishController {

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
	public String index(Model model, @RequestParam(value = "forwardURL", required = true) String forwardURL) {

		model.addAttribute("forwardURL", forwardURL);
		return "finish";
	}
}
