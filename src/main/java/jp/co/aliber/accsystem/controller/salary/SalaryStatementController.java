package jp.co.aliber.accsystem.controller.salary;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.form.common.MessageForm;
import jp.co.aliber.accsystem.form.salary.SalaryStatementForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.employee.EmployeeService;

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
	EmployeeService tEmployeeService;

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
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(@AuthenticationPrincipal LoginUser loginUser, Model model, SalaryStatementForm form,
			MessageForm messageForm) {

		// ユーザー新規登録の場合、会社IDがないので、会社基本情報設定画面に遷移
		if (loginUser.getUser().getCompId() == null) {
			// メッセージ情報を設定
			messageForm.setMessage(ImmutableValues.MESSAGE_INSERT_COMPANY);
			messageForm.setForwardURL(ImmutableValues.FORWARD_COMPANY);
			return "message";
		}

		// 月リスト
		List<String> listMonth = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
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
		// 選択された年:デフォルト値:今月
		form.setSalaryMonth(StringUtils.leftPad(thisMonth + "", 2, '0'));

		// 從業員情報リストを取得
		List<TEmployee> listTEmployee = tEmployeeService.getListTEmployee(loginUser.getUser().getCompId());
		form.setListTEmployee(listTEmployee);

		// 会社ID
		form.setCompId(loginUser.getUser().getCompId());
		return "salary/salary_statement";
	}
}
