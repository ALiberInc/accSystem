package jp.co.aliber.accsystem.controller.company;

import java.util.Locale;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.form.company.CompanyInfoFrom;


@Controller
@RequestMapping("/company_info")
public class CompanyInfoController {

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
    public String index(Locale locale, Model model, CompanyInfoFrom form) {

        return "_company/company_info";
    }

}
