package jp.co.aliber.accsystem.controller.salary;

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
import jp.co.aliber.accsystem.form.salary.SalaryStatementFrom;
import jp.co.aliber.accsystem.service.employee.TEmployeeService;

/**
 * 給与明細印刷画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/salary_statement")
public class SalaryStatementController {

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

    /**
     * 給与明細印刷画面
     *
     * @param locale
     * @param model
     * @param form
     * @return
     */
    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String index(Locale locale, Model model, SalaryStatementFrom form) {

        // 從業員情報リストを取得
        List<TEmployee> listTEmployee = tEmployeeService.getListTEmployee(1);
        form.setListTEmployee(listTEmployee);
        return "salary/salary_statement";
    }

    // /**
    // * @param freeWord
    // * フリーワード
    // */
    // @RequestMapping(value = { "/search" }, method = RequestMethod.POST,
    // produces = "application/json; charset=utf-8")
    // @ResponseBody
    // public String save(@RequestParam(value = "freeWord") String freeWord,
    // SalaryStatementFrom form) {
    //
    // List<TEmployee> listTEmployee = new ArrayList<TEmployee>();
    // TEmployeeExample tEmployeeExample = new TEmployeeExample();
    // if (freeWord == null) {
    // listTEmployee = tEmployeeMapper.selectByExample(tEmployeeExample);
    // } else {
    // tEmployeeExample.createCriteria().andLastNameLike(freeWord);
    // listTEmployee = tEmployeeMapper.selectByExample(tEmployeeExample);
    // }
    // form.setListTEmployee(listTEmployee);
    // return "_salary/salary_statement";
    //
    // }
}
