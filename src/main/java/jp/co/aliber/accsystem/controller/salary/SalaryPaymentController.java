package jp.co.aliber.accsystem.controller.salary;

import java.util.Locale;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.form.salary.SalaryPaymentFrom;

/**
 * 給与明細画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/salary_payment")
public class SalaryPaymentController {

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
     * 給与明細画面
     *
     */
    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String index(Locale locale, Model model, SalaryPaymentFrom form) {

        return "_salary/salary_payment";
    }
}
