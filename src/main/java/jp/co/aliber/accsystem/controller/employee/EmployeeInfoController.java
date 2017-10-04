package jp.co.aliber.accsystem.controller.employee;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.form.employee.EmployeeInfoFrom;
import jp.co.aliber.accsystem.service.employee.TEmployeeService;

/**
 * 從業員情報一覧画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/employee_info")
public class EmployeeInfoController {

    // 從業員情報サービス
    @Autowired
    TEmployeeService tEmployeeService;

    /**
     * データのバンディング
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /**從業員情報一覧画面
     * @param locale
     * @param model
     * @param form
     * @return
     */
    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String index(Locale locale, Model model, EmployeeInfoFrom form) {

        // 從業員情報リストを取得
        List<TEmployee> listTEmployee = tEmployeeService.getListTEmployee(1);
        form.setListTEmployee(listTEmployee);
        return "employee/employee_info";
    }
}
