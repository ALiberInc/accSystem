package jp.co.aliber.accsystem.form.salary;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 従業員給与明細入力form
 *
 * @author yu_k
 *
 */
public class SalaryDetailsInputForm {

	// 従業員ID
	@NotNull
	private Integer employeeId;
	// 年月
	private String salaryYearMonth;
	// 固定支給金額番号
	private Integer fixedPaymentId;
	// 基本給
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer basicSalary;
	// 役職手当
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer positionAllowance;
	// 資格手当
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer qualificationAllowance;
	// 住宅手当
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer houseAllowance;
	// 家族手当
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer familyAllowance;
	// その他手当
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer otherAllowance;
	// 交通費(実費)
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer transportFee;
	// 総支給
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer sum;
	// 固定控除金額番号
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer fixedDeductionId;
	// 健康保険
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer healthInsurance;
	// 厚生年金
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer welfarePension;
	// 雇用保険
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer employmentInsurance;
	// 社会保険合計
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer socialInsuranceSum;
	// 所得税
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer incomeTax;
	// 住民税
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer inhabitantTax;
	// 旅行積立金
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer travelFund;
	// 借入等返済
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer repaymentBorrowings;
	// 年末控除
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer yearendDeduction;
	// 家賃控除
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer rentDeduction;
	// その他控除
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer otherDeduction;
	// 控除額合計
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer totalDeductibleSum;
	// 差引支給額
	@NotNull
	@Min(value = 0)
	@Max(value = 200_000_000)
	private Integer subscriptionAmount;
	// 健康保険手入力
	private boolean healthInsuranceFlag;
	// 厚生年金手入力
	private boolean welfareInsuranceFlag;
	// 雇用保険手入力
	private boolean employInsuranceFlag;

	/**
	 * @return employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            セットする employeeId
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return salaryYearMonth
	 */
	public String getSalaryYearMonth() {
		return salaryYearMonth;
	}

	/**
	 * @param salaryYearMonth
	 *            セットする salaryYearMonth
	 */
	public void setSalaryYearMonth(String salaryYearMonth) {
		this.salaryYearMonth = salaryYearMonth;
	}

	/**
	 * @return fixedPaymentId
	 */
	public Integer getFixedPaymentId() {
		return fixedPaymentId;
	}

	/**
	 * @param fixedPaymentId
	 *            セットする fixedPaymentId
	 */
	public void setFixedPaymentId(Integer fixedPaymentId) {
		this.fixedPaymentId = fixedPaymentId;
	}

	/**
	 * @return basicSalary
	 */
	public Integer getBasicSalary() {
		return basicSalary;
	}

	/**
	 * @param basicSalary
	 *            セットする basicSalary
	 */
	public void setBasicSalary(Integer basicSalary) {
		this.basicSalary = basicSalary;
	}

	/**
	 * @return positionAllowance
	 */
	public Integer getPositionAllowance() {
		return positionAllowance;
	}

	/**
	 * @param positionAllowance
	 *            セットする positionAllowance
	 */
	public void setPositionAllowance(Integer positionAllowance) {
		this.positionAllowance = positionAllowance;
	}

	/**
	 * @return qualificationAllowance
	 */
	public Integer getQualificationAllowance() {
		return qualificationAllowance;
	}

	/**
	 * @param qualificationAllowance
	 *            セットする qualificationAllowance
	 */
	public void setQualificationAllowance(Integer qualificationAllowance) {
		this.qualificationAllowance = qualificationAllowance;
	}

	/**
	 * @return houseAllowance
	 */
	public Integer getHouseAllowance() {
		return houseAllowance;
	}

	/**
	 * @param houseAllowance
	 *            セットする houseAllowance
	 */
	public void setHouseAllowance(Integer houseAllowance) {
		this.houseAllowance = houseAllowance;
	}

	/**
	 * @return familyAllowance
	 */
	public Integer getFamilyAllowance() {
		return familyAllowance;
	}

	/**
	 * @param familyAllowance
	 *            セットする familyAllowance
	 */
	public void setFamilyAllowance(Integer familyAllowance) {
		this.familyAllowance = familyAllowance;
	}

	/**
	 * @return otherAllowance
	 */
	public Integer getOtherAllowance() {
		return otherAllowance;
	}

	/**
	 * @param otherAllowance
	 *            セットする otherAllowance
	 */
	public void setOtherAllowance(Integer otherAllowance) {
		this.otherAllowance = otherAllowance;
	}

	/**
	 * @return transportFee
	 */
	public Integer getTransportFee() {
		return transportFee;
	}

	/**
	 * @param transportFee
	 *            セットする transportFee
	 */
	public void setTransportFee(Integer transportFee) {
		this.transportFee = transportFee;
	}

	/**
	 * @return sum
	 */
	public Integer getSum() {
		return sum;
	}

	/**
	 * @param sum
	 *            セットする sum
	 */
	public void setSum(Integer sum) {
		this.sum = sum;
	}

	/**
	 * @return fixedDeductionId
	 */
	public Integer getFixedDeductionId() {
		return fixedDeductionId;
	}

	/**
	 * @param fixedDeductionId
	 *            セットする fixedDeductionId
	 */
	public void setFixedDeductionId(Integer fixedDeductionId) {
		this.fixedDeductionId = fixedDeductionId;
	}

	/**
	 * @return healthInsurance
	 */
	public Integer getHealthInsurance() {
		return healthInsurance;
	}

	/**
	 * @param healthInsurance
	 *            セットする healthInsurance
	 */
	public void setHealthInsurance(Integer healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	/**
	 * @return welfarePension
	 */
	public Integer getWelfarePension() {
		return welfarePension;
	}

	/**
	 * @param welfarePension
	 *            セットする welfarePension
	 */
	public void setWelfarePension(Integer welfarePension) {
		this.welfarePension = welfarePension;
	}

	/**
	 * @return employmentInsurance
	 */
	public Integer getEmploymentInsurance() {
		return employmentInsurance;
	}

	/**
	 * @param employmentInsurance
	 *            セットする employmentInsurance
	 */
	public void setEmploymentInsurance(Integer employmentInsurance) {
		this.employmentInsurance = employmentInsurance;
	}

	/**
	 * @return socialInsuranceSum
	 */
	public Integer getSocialInsuranceSum() {
		return socialInsuranceSum;
	}

	/**
	 * @param socialInsuranceSum
	 *            セットする socialInsuranceSum
	 */
	public void setSocialInsuranceSum(Integer socialInsuranceSum) {
		this.socialInsuranceSum = socialInsuranceSum;
	}

	/**
	 * @return incomeTax
	 */
	public Integer getIncomeTax() {
		return incomeTax;
	}

	/**
	 * @param incomeTax
	 *            セットする incomeTax
	 */
	public void setIncomeTax(Integer incomeTax) {
		this.incomeTax = incomeTax;
	}

	/**
	 * @return inhabitantTax
	 */
	public Integer getInhabitantTax() {
		return inhabitantTax;
	}

	/**
	 * @param inhabitantTax
	 *            セットする inhabitantTax
	 */
	public void setInhabitantTax(Integer inhabitantTax) {
		this.inhabitantTax = inhabitantTax;
	}

	/**
	 * @return travelFund
	 */
	public Integer getTravelFund() {
		return travelFund;
	}

	/**
	 * @param travelFund
	 *            セットする travelFund
	 */
	public void setTravelFund(Integer travelFund) {
		this.travelFund = travelFund;
	}

	/**
	 * @return repaymentBorrowings
	 */
	public Integer getRepaymentBorrowings() {
		return repaymentBorrowings;
	}

	/**
	 * @param repaymentBorrowings
	 *            セットする repaymentBorrowings
	 */
	public void setRepaymentBorrowings(Integer repaymentBorrowings) {
		this.repaymentBorrowings = repaymentBorrowings;
	}

	/**
	 * @return yearendDeduction
	 */
	public Integer getYearendDeduction() {
		return yearendDeduction;
	}

	/**
	 * @param yearendDeduction
	 *            セットする yearendDeduction
	 */
	public void setYearendDeduction(Integer yearendDeduction) {
		this.yearendDeduction = yearendDeduction;
	}

	/**
	 * @return rentDeduction
	 */
	public Integer getRentDeduction() {
		return rentDeduction;
	}

	/**
	 * @param rentDeduction
	 *            セットする rentDeduction
	 */
	public void setRentDeduction(Integer rentDeduction) {
		this.rentDeduction = rentDeduction;
	}

	/**
	 * @return otherDeduction
	 */
	public Integer getOtherDeduction() {
		return otherDeduction;
	}

	/**
	 * @param otherDeduction
	 *            セットする otherDeduction
	 */
	public void setOtherDeduction(Integer otherDeduction) {
		this.otherDeduction = otherDeduction;
	}

	/**
	 * @return totalDeductibleSum
	 */
	public Integer getTotalDeductibleSum() {
		return totalDeductibleSum;
	}

	/**
	 * @param totalDeductibleSum
	 *            セットする totalDeductibleSum
	 */
	public void setTotalDeductibleSum(Integer totalDeductibleSum) {
		this.totalDeductibleSum = totalDeductibleSum;
	}

	/**
	 * @return subscriptionAmount
	 */
	public Integer getSubscriptionAmount() {
		return subscriptionAmount;
	}

	/**
	 * @param subscriptionAmount
	 *            セットする subscriptionAmount
	 */
	public void setSubscriptionAmount(Integer subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}

	/**
	 * @return healthInsuranceFlag
	 */
	public boolean isHealthInsuranceFlag() {
		return healthInsuranceFlag;
	}

	/**
	 * @param healthInsuranceFlag
	 *            セットする healthInsuranceFlag
	 */
	public void setHealthInsuranceFlag(boolean healthInsuranceFlag) {
		this.healthInsuranceFlag = healthInsuranceFlag;
	}

	/**
	 * @return welfareInsuranceFlag
	 */
	public boolean isWelfareInsuranceFlag() {
		return welfareInsuranceFlag;
	}

	/**
	 * @param welfareInsuranceFlag
	 *            セットする welfareInsuranceFlag
	 */
	public void setWelfareInsuranceFlag(boolean welfareInsuranceFlag) {
		this.welfareInsuranceFlag = welfareInsuranceFlag;
	}

	/**
	 * @return employInsuranceFlag
	 */
	public boolean isEmployInsuranceFlag() {
		return employInsuranceFlag;
	}

	/**
	 * @param employInsuranceFlag
	 *            セットする employInsuranceFlag
	 */
	public void setEmployInsuranceFlag(boolean employInsuranceFlag) {
		this.employInsuranceFlag = employInsuranceFlag;
	}

}
