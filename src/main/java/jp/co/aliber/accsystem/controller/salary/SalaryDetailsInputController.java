package jp.co.aliber.accsystem.controller.salary;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.entity.auto.TEmployeeIncomeTax;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.form.salary.SalaryDetailsInputForm;
import jp.co.aliber.accsystem.mapper.auto.MIncomeTaxMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeFixedDeductionMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeFixedPaymentMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeIncomeTaxMapper;
import jp.co.aliber.accsystem.mapper.auto.TSalaryDetailMapper;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.salary.SalaryDetailsInputService;

/**
 * 給与明細入力controller
 *
 * @author yu_k
 *
 */
@Controller
@RequestMapping("/detail")
public class SalaryDetailsInputController {
	@Autowired
	SalaryDetailsInputService salaryDetailsInputService;
	@Autowired
	TSalaryDetailMapper tSalaryDetailMapper;
	@Autowired
	TEmployeeFixedPaymentMapper tEmployeeFixedPaymentMapper;
	@Autowired
	TEmployeeFixedDeductionMapper tEmployeeFixedDeductionMapper;
	@Autowired
	TEmployeeIncomeTaxMapper tEmployeeIncomeTaxMapper;
	@Autowired
	MIncomeTaxMapper mIncomeTaxMapper;

	/**
	 * 初期値設定
	 *
	 * @param model
	 *            モデル
	 * @param form
	 *            給与明細入力画面Form
	 * @param yearMonth
	 *            年月
	 * @param employeeId
	 *            従業員ID
	 * @param loginUser
	 *            ログインユーザ
	 * @return 給与明細入力画面
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute SalaryDetailsInputForm form,
			@RequestParam(value = "yearMonth", required = true) String yearMonth,
			@RequestParam(value = "employeeId", required = true) Integer employeeId,
			@AuthenticationPrincipal LoginUser loginUser) {
		// 先画面から取得する
		form.setEmployeeId(employeeId);
		form.setSalaryYearMonth(yearMonth);
		// ログイン情報から取得
		Integer compId = loginUser.getUser().getCompId();
		// 扶養親族等の数を従業員所得税情報テーブルから取得する
		TEmployeeIncomeTax tEmployeeIncomeTax = tEmployeeIncomeTaxMapper.selectByPrimaryKey(employeeId, compId);

		// 扶養親族等の数
		Integer person = 0;
		if (tEmployeeIncomeTax != null) {
			person = tEmployeeIncomeTax.getDependencyCount();
		}

		TSalaryDetail tSalaryDetail = salaryDetailsInputService.initiation(employeeId, compId, person, yearMonth);
		// 基本給
		form.setBasicSalary(tSalaryDetail.getBasicSalary());
		// 役職手当
		form.setPositionAllowance(tSalaryDetail.getPositionAllowance());
		// 資格手当
		form.setQualificationAllowance(tSalaryDetail.getQualificationAllowance());
		// 住宅手当
		form.setHouseAllowance(tSalaryDetail.getHouseAllowance());
		// 交通費(実費)
		form.setFamilyAllowance(tSalaryDetail.getFamilyAllowance());
		// その他手当
		form.setOtherAllowance(tSalaryDetail.getOtherAllowance());
		// 交通費(実費)
		form.setTransportFee(tSalaryDetail.getTransportFee());
		// 総支給
		form.setSum(tSalaryDetail.getTotalPay());
		// 健康保険
		form.setHealthInsurance(tSalaryDetail.getHealthInsurance());
		// 厚生年金
		form.setWelfarePension(tSalaryDetail.getWelfareInsurance());
		// 雇用保険
		form.setEmploymentInsurance(tSalaryDetail.getEmployInsurance());
		// 社会保険合計
		form.setSocialInsuranceSum(tSalaryDetail.getTotalInsurance());
		// 所得税
		form.setIncomeTax(tSalaryDetail.getIncomeTax());
		// 住民税
		form.setInhabitantTax(tSalaryDetail.getLivingTax());
		// 旅行積立金
		form.setTravelFund(tSalaryDetail.getTravelFund());
		// 借入等返済
		form.setRepaymentBorrowings(tSalaryDetail.getRepaymentBorrowings());
		// 年末控除
		form.setYearendDeduction(tSalaryDetail.getYearendDeduction());
		// 家賃控除
		form.setRentDeduction(tSalaryDetail.getRentDeduction());
		// その他の控除
		form.setOtherDeduction(tSalaryDetail.getOtherDeduction());
		// 控除額合計
		form.setTotalDeductibleSum(tSalaryDetail.getTotalDeductibleAmount());
		// 差引支給額
		form.setSubscriptionAmount(tSalaryDetail.getSubscriptionAmount());

		return "salary/salaryDetailsInput";
	}

	/**
	 * 登録ボタンを押下する時
	 *
	 * @param locale
	 *            ロケ－ル
	 * @param model
	 *            モデル
	 * @param form
	 *            給与明細入力画面Form
	 * @param loginUser
	 *            ログインユーザ
	 * @return 給与明細入力画面
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String save(Locale locale, Model model, @ModelAttribute SalaryDetailsInputForm form,
			@AuthenticationPrincipal LoginUser loginUser) {
		// formから必要情報を取得する
		Integer employeeID = form.getEmployeeId();
		Integer compId = loginUser.getUser().getCompId();
		String yearMonth = form.getSalaryYearMonth();
		TSalaryDetail tSalaryDetail = new TSalaryDetail();
		// 従業員ID
		tSalaryDetail.setEmployeeId(employeeID);
		// 会社ID
		tSalaryDetail.setCompId(compId);
		// 年月
		tSalaryDetail.setSalaryYearMonth(yearMonth);
		// 年月
		tSalaryDetail.setPayDate(new Date());
		// 基本給
		tSalaryDetail.setBasicSalary(form.getBasicSalary());
		// 役職手当
		tSalaryDetail.setPositionAllowance(form.getPositionAllowance());
		// 資格手当
		tSalaryDetail.setQualificationAllowance(form.getQualificationAllowance());
		// 住宅手当
		tSalaryDetail.setHouseAllowance(form.getHouseAllowance());
		// 家族手当
		tSalaryDetail.setFamilyAllowance(form.getFamilyAllowance());
		// その他手当
		tSalaryDetail.setOtherAllowance(form.getOtherAllowance());
		// 交通費(実費)
		tSalaryDetail.setTransportFee(form.getTransportFee());
		// 総支給
		tSalaryDetail.setTotalPay(form.getSum());
		// 健康保険
		tSalaryDetail.setHealthInsurance(form.getHealthInsurance());
		// 厚生年金
		tSalaryDetail.setWelfareInsurance(form.getWelfarePension());
		// 雇用保険
		tSalaryDetail.setEmployInsurance(form.getEmploymentInsurance());
		// 社会保険合計
		tSalaryDetail.setTotalInsurance(form.getSocialInsuranceSum());
		// 所得税
		tSalaryDetail.setIncomeTax(form.getIncomeTax());
		// 住民税
		tSalaryDetail.setLivingTax(form.getInhabitantTax());
		// 旅行積立金
		tSalaryDetail.setTravelFund(form.getTravelFund());
		// 借入等返済
		tSalaryDetail.setRepaymentBorrowings(form.getRepaymentBorrowings());
		// 年末控除
		tSalaryDetail.setYearendDeduction(form.getYearendDeduction());
		// 家賃控除
		tSalaryDetail.setRentDeduction(form.getRentDeduction());
		// その他の控除
		tSalaryDetail.setOtherDeduction(form.getOtherDeduction());
		// 控除額合計
		tSalaryDetail.setTotalDeductibleAmount(form.getTotalDeductibleSum());
		// 差引支給額
		tSalaryDetail.setSubscriptionAmount(form.getSubscriptionAmount());

		// 登録処理
		salaryDetailsInputService.update(tSalaryDetail);

		return "redirect:/finish?forwardURL=salary_statement";
	}
}
