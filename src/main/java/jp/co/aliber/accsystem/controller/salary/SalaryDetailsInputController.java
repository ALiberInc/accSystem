package jp.co.aliber.accsystem.controller.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedDeduction;
import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedPayment;
import jp.co.aliber.accsystem.entity.auto.TEmployeeIncomeTax;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.form.common.MessageForm;
import jp.co.aliber.accsystem.form.salary.SalaryDetailsInputForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;
import jp.co.aliber.accsystem.service.employee.EmployeeFixedDeductionService;
import jp.co.aliber.accsystem.service.employee.EmployeeFixedPaymentService;
import jp.co.aliber.accsystem.service.employee.EmployeeIncomeTaxService;
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
	EmployeeIncomeTaxService employeeIncomeTaxService;
	@Autowired
	EmployeeFixedPaymentService employeeFixedPaymentService;
	@Autowired
	EmployeeFixedDeductionService employeeFixedDeductionService;
	@Autowired
	CompanyBasicInfoService companyBasicInfoService;

	/**
	 * @param form
	 * @param yearMonth
	 * @param employeeId
	 * @param loginUser
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(@ModelAttribute SalaryDetailsInputForm form,
			@RequestParam(value = "yearMonth", required = true) String yearMonth,
			@RequestParam(value = "employeeId", required = true) Integer employeeId,
			@AuthenticationPrincipal LoginUser loginUser) {

		// 前画面から取得する
		form.setEmployeeId(employeeId);
		form.setSalaryYearMonth(yearMonth);
		// ログイン情報から取得
		Integer compId = loginUser.getUser().getCompId();
		TSalaryDetail salaryDetail = salaryDetailsInputService.getSalaryDetail(employeeId, compId, yearMonth);

		if (salaryDetail == null) {
			// 各給与を格納
			List<Integer> paymentList = new ArrayList<>();
			// 基本給
			TEmployeeFixedPayment employeeFixedPayment = employeeFixedPaymentService
					.getTEmployeeFixedPayment(employeeId, compId);
			paymentList.add(employeeFixedPayment.getBasicSalary());
			form.setBasicSalary(employeeFixedPayment.getBasicSalary());
			// 役職手当
			paymentList.add(employeeFixedPayment.getPositionAllowance());
			form.setPositionAllowance(employeeFixedPayment.getPositionAllowance());
			// 資格手当
			paymentList.add(employeeFixedPayment.getQualificationAllowance());
			form.setQualificationAllowance(employeeFixedPayment.getQualificationAllowance());
			// 住宅手当
			paymentList.add(employeeFixedPayment.getHouseAllowance());
			form.setHouseAllowance(employeeFixedPayment.getHouseAllowance());
			// 家族手当
			paymentList.add(employeeFixedPayment.getFamilyAllowance());
			form.setFamilyAllowance(employeeFixedPayment.getFamilyAllowance());
			// その他手当
			paymentList.add(employeeFixedPayment.getOtherAllowance());
			form.setOtherAllowance(employeeFixedPayment.getOtherAllowance());
			// 交通費(実費)
			form.setTransportFee(employeeFixedPayment.getTransportFee());
			// 総支給
			int sum = paymentList.stream().filter(payment -> payment != null).mapToInt(Integer::intValue).sum();

			form.setSum(sum
					+ (employeeFixedPayment.getTransportFee() == null ? 0 : employeeFixedPayment.getTransportFee()));
			// 各控除額を格納をここで置く
			List<Integer> listDeduction = new ArrayList<>();
			// 総支給によって、保険について各項目を取得する
			Map<String, Integer> map = new HashMap<>();
			map = salaryDetailsInputService.insuranceCalculator(sum, compId);
			// 健康保険
			form.setHealthInsurance(map.get("healthInsurance"));
			// 厚生年金
			form.setWelfarePension(map.get("welfarePension"));
			// 雇用保険
			form.setEmploymentInsurance(map.get("employmentInsurance"));
			// 社会保険合計
			form.setSocialInsuranceSum(map.get("socialInsuranceSum"));
			listDeduction.add(map.get("socialInsuranceSum"));

			// 扶養親族等の数を従業員所得税情報テーブルから取得する
			TEmployeeIncomeTax tEmployeeIncomeTax = employeeIncomeTaxService.getTEmployeeIncomeTax(employeeId, compId);

			// 扶養親族等の数
			Integer person = 0;
			if (tEmployeeIncomeTax != null) {
				person = tEmployeeIncomeTax.getDependencyCount();
			}
			// 所得税
			Integer incomeTax = salaryDetailsInputService.incomeTaxCalculator(sum, map.get("socialInsuranceSum"),
					person);
			listDeduction.add(incomeTax);
			form.setIncomeTax(incomeTax);
			// 住民税
			form.setInhabitantTax(null);
			// 従業員固定控除金額情報テーブルから固定控除金額情報を取得
			TEmployeeFixedDeduction tEmployeeFixedDeduction = employeeFixedDeductionService
					.getTEmployeeFixedDeduction(employeeId, compId);
			// 旅行積立金
			Integer travelFund = tEmployeeFixedDeduction.getTravelFund();
			listDeduction.add(travelFund);
			form.setTravelFund(travelFund);
			// 借入等返済
			Integer repaymentBorrowings = tEmployeeFixedDeduction.getRepaymentBorrowings();
			listDeduction.add(repaymentBorrowings);
			form.setRepaymentBorrowings(repaymentBorrowings);
			// 年末控除
			Integer yearendDeduction = tEmployeeFixedDeduction.getYearendDeduction();
			listDeduction.add(yearendDeduction);
			form.setYearendDeduction(yearendDeduction);
			// 家賃控除
			Integer rentDeduction = tEmployeeFixedDeduction.getRentDeduction();
			listDeduction.add(rentDeduction);
			form.setRentDeduction(rentDeduction);
			// その他の控除
			Integer otherDeduction = tEmployeeFixedDeduction.getOtherDeduction();
			listDeduction.add(otherDeduction);
			form.setOtherDeduction(otherDeduction);
			// 控除額合計
			int deductionSum = listDeduction.stream().filter(deduction -> deduction != null).mapToInt(Integer::intValue)
					.sum();
			form.setTotalDeductibleSum(deductionSum);
			// 差引支給額
			form.setSubscriptionAmount(sum - deductionSum);
		} else {
			// 基本給
			form.setBasicSalary(salaryDetail.getBasicSalary());
			// 役職手当
			form.setPositionAllowance(salaryDetail.getPositionAllowance());
			// 資格手当
			form.setQualificationAllowance(salaryDetail.getQualificationAllowance());
			// 住宅手当
			form.setHouseAllowance(salaryDetail.getHouseAllowance());
			// 交通費(実費)
			form.setFamilyAllowance(salaryDetail.getFamilyAllowance());
			// その他手当
			form.setOtherAllowance(salaryDetail.getOtherAllowance());
			// 交通費(実費)
			form.setTransportFee(salaryDetail.getTransportFee());
			// 総支給
			form.setSum(salaryDetail.getTotalPay());
			// 健康保険
			form.setHealthInsurance(salaryDetail.getHealthInsurance());
			// 厚生年金
			form.setWelfarePension(salaryDetail.getWelfareInsurance());
			// 雇用保険
			form.setEmploymentInsurance(salaryDetail.getEmployInsurance());
			// 社会保険合計
			form.setSocialInsuranceSum(salaryDetail.getTotalInsurance());
			// 所得税
			form.setIncomeTax(salaryDetail.getIncomeTax());
			// 住民税
			form.setInhabitantTax(salaryDetail.getLivingTax());
			// 旅行積立金
			form.setTravelFund(salaryDetail.getTravelFund());
			// 借入等返済
			form.setRepaymentBorrowings(salaryDetail.getRepaymentBorrowings());
			// 年末控除
			form.setYearendDeduction(salaryDetail.getYearendDeduction());
			// 家賃控除
			form.setRentDeduction(salaryDetail.getRentDeduction());
			// その他の控除
			form.setOtherDeduction(salaryDetail.getOtherDeduction());
			// 控除額合計
			form.setTotalDeductibleSum(salaryDetail.getTotalDeductibleAmount());
			// 差引支給額
			form.setSubscriptionAmount(salaryDetail.getSubscriptionAmount());
		}

		return "salary/salary_details_input";
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
	public String save(@AuthenticationPrincipal LoginUser loginUser, @Validated SalaryDetailsInputForm form,
			BindingResult result, MessageForm messageForm) {

		// 入力チェック
		if (!validate(form, result)) {
			return "salary/salary_details_input";
		}

		TSalaryDetail tSalaryDetail = new TSalaryDetail();
		// 従業員ID
		tSalaryDetail.setEmployeeId(form.getEmployeeId());
		// 会社ID
		tSalaryDetail.setCompId(loginUser.getUser().getCompId());
		// 年月
		tSalaryDetail.setSalaryYearMonth(form.getSalaryYearMonth());

		// 会社情報を取得
		TCompany companyInfo = companyBasicInfoService.searchComp(loginUser.getUser().getCompId());
		Calendar cal = Calendar.getInstance();
		if (new Boolean(true).equals(companyInfo.getPaymentDay())) {
			// 支給日が末日の場合
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
			// 年月
			tSalaryDetail.setPayDate(cal.getTime());
		} else {
			// 支給日が末日以外の場合
			cal.set(Calendar.DATE, companyInfo.getPaymentAdjustDays());
			// 年月
			tSalaryDetail.setPayDate(cal.getTime());
		}

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

		TSalaryDetail existSalaryDetail = salaryDetailsInputService.getSalaryDetail(tSalaryDetail.getEmployeeId(),
				tSalaryDetail.getCompId(), tSalaryDetail.getSalaryYearMonth());
		if (existSalaryDetail == null) {
			// 登録処理
			salaryDetailsInputService.insert(tSalaryDetail);
		} else {
			salaryDetailsInputService.update(tSalaryDetail);
		}

		// メッセージ情報を設定
		messageForm.setMessage(ImmutableValues.MESSAGE_FINISH_SALARY_DETAIL_INPUT);
		messageForm.setForwardURL(ImmutableValues.FORWARD_SALARY_STATEMENT);
		return "message";
	}

	/**
	 * 入力チェック
	 *
	 * @param SalaryDetailsInputForm<br>
	 *            ログイン者情報編集Form
	 * @param BindingResult<br>
	 *            Resultバンディング
	 * @return validateResult<br>
	 *         入力チェック結果
	 */
	private boolean validate(SalaryDetailsInputForm form, BindingResult result) {

		boolean validateResult = true;

		// 入力チェック
		if (result.hasErrors()) {
			validateResult = false;
		}

		// 入力チェック結果
		return validateResult;
	}
}
