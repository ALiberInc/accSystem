package jp.co.aliber.accsystem.controller.salary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.form.salary.SalaryStatementForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.employee.TEmployeeService;

/**
 * 給与明細一覧画面
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
	 * 給与明細一覧画面
	 *
	 * @param form
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(@AuthenticationPrincipal LoginUser loginUser, SalaryStatementForm form) {

		// 從業員情報リストを取得
		List<TEmployee> listTEmployee = tEmployeeService.getListTEmployee(loginUser.getUser().getCompId());
		form.setListTEmployee(listTEmployee);
		return "salary/salary_statement";
	}
}
