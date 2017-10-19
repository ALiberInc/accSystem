package jp.co.aliber.accsystem.controller.salary;

import java.util.ArrayList;
import java.util.Calendar;
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
		// 月リスト
		List<String> listMonth = new ArrayList<>();
		listMonth.add("01");
		listMonth.add("02");
		listMonth.add("03");
		listMonth.add("04");
		listMonth.add("05");
		listMonth.add("06");
		listMonth.add("07");
		listMonth.add("08");
		listMonth.add("09");
		listMonth.add("10");
		listMonth.add("11");
		listMonth.add("12");
		form.setMonthList(listMonth);

		// 年リスト
		List<String> listYear = new ArrayList<>();
		// 今年を取得
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		// 5年前から来年まで
		for (int i = thisYear - 5; i <= thisYear + 1; i++) {
			listYear.add(i + "");
		}
		form.setYearList(listYear);
		// 選択された年:デフォルト値:今年
		form.setSalaryYear(thisYear + "");

		// 今月
		int thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		for (String a : listMonth) {
			if (Integer.valueOf(a).intValue() == thisMonth) {
				form.setSalaryMonth(a);
				break;
			}
		}

		// 從業員情報リストを取得
		List<TEmployee> listTEmployee = tEmployeeService.getListTEmployee(loginUser.getUser().getCompId());
		form.setListTEmployee(listTEmployee);

		// 会社ID
		form.setCompId(loginUser.getUser().getCompId());
		return "salary/salary_statement";
	}
}
