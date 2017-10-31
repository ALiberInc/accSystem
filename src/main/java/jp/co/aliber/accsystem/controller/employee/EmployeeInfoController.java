package jp.co.aliber.accsystem.controller.employee;

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
import jp.co.aliber.accsystem.form.employee.EmployeeInfoForm;
import jp.co.aliber.accsystem.security.LoginUser;
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

	/**
	 * 從業員情報一覧画面
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(@AuthenticationPrincipal LoginUser loginUser, EmployeeInfoForm form) {

		// ユーザー新規登録の場合、会社IDがないので、会社基本情報設定画面に遷移
		if (loginUser.getUser().getCompId() == null) {
			return "redirect:/companyUpdate";
		}

		// 從業員情報リストを取得
		List<TEmployee> listTEmployee = tEmployeeService.getListTEmployee(loginUser.getUser().getCompId());
		form.setListTEmployee(listTEmployee);
		return "employee/employee_info";
	}
}
