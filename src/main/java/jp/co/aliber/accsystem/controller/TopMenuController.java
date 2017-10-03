package jp.co.aliber.accsystem.controller;

import java.util.Locale;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.form.TopMenuFrom;


@Controller
@RequestMapping("/top_menu")
public class TopMenuController {


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
     * メニュー画面
     *
     */
    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String index(Locale locale, Model model, TopMenuFrom form) {


        return "top_menu";
    }
}
