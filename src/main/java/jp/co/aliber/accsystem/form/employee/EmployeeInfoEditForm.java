package jp.co.aliber.accsystem.form.employee;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import jp.co.aliber.accsystem.entity.auto.TCompanyDepartment;

public class EmployeeInfoEditForm {

	/**
	 * 新規と更新のフラグ
	 */
	private boolean creationflag;

	/**
	 * 従業員番号
	 */
	@NotNull
	private String employeeNo;

	/**
	 * 従業員番号
	 */
	private Integer employeeId;

	/**
	 * フリガナ
	 */
	@Size(max = 50)
	private String firstNameKana;

	/**
	 * フリガナ
	 */
	@Size(max = 50)
	private String lastNameKana;

	/**
	 * 氏名
	 */
	@NotBlank
	@Size(max = 50)
	private String firstName;

	/**
	 * 氏名
	 */
	@NotBlank
	@Size(max = 50)
	private String lastName;

	/**
	 * 性別
	 */
	@NotNull
	private Integer sex;

	/**
	 * 部署
	 */
	@NotNull
	private Integer department;

	/**
	 * 部署リスト
	 */
	private List<TCompanyDepartment> departmentList;

	/**
	 * メルアドレース
	 */
	@Email
	@Size(max = 100)
	private String email;

	/**
	 * 口座名義人
	 */
	@NotBlank
	@Size(max = 100)
	@Pattern(regexp = "[ァ-ヶー]*")
	private String accountHolder;

	/**
	 * 銀行コード
	 */
	@NotNull
	private String bankCode;

	/**
	 * 銀行名
	 */
	@NotBlank
	@Size(max = 100)
	private String bankName;

	/**
	 * 口座種別
	 */
	private Integer accountType;

	/**
	 * 本支店コード
	 */
	private String branchCode;

	/**
	 * 本支店名
	 */
	@Size(max = 100)
	private String branchName;

	/**
	 * 口座番号
	 */
	private String accountNumber;

	/**
	 * 所得税区分
	 */
	@NotNull
	private Integer incomeTaxDistinction;

	/**
	 * 控除対象配偶者
	 */
	@NotNull
	private Integer consort;

	/**
	 * 扶養控除等の申告
	 */
	@NotNull
	private Integer dependents;

	/**
	 * 扶養人数
	 */
	@NotNull
	private Integer dependentsNumber;

	/**
	 * 世帯主名
	 */
	@Size(max = 100)
	@NotNull
	private String householdName;

	/**
	 * 続柄
	 */
	@Size(max = 50)
	private String relationship;

	/**
	 * 条約免除
	 */
	private Boolean treatyExemption;

	/**
	 * 青色専従者
	 */
	private Boolean blueOfficer;

	/**
	 * 雇用保険
	 */
	@NotNull
	private Short insuranceFlag;

	/**
	 * 健康保険
	 */
	@NotNull
	private Short healthInsuranceFlag;

	/**
	 * 健康保険種別
	 */
	private Short healthInsuranceType;

	/**
	 * 健康保険の標準報酬
	 */
	private Short healthCompensation;

	/**
	 * 保険者番号
	 */
	private Long insurerNumber;

	/**
	 * 被保険者整理番号
	 */
	private Long insuredPersonnelNumber;

	/**
	 * 厚生年金
	 */
	@NotNull
	private Integer welfarePensionFlag;

	/**
	 * 厚生年金の標準報酬
	 */
	private Short welfareCompensation;

	/**
	 * 基礎年金番号
	 */
	private Long welfareNumber;

	/**
	 * 厚生年金基金
	 */
	@NotNull
	private Integer welfareFund;

	/**
	 * 基本給
	 */
	@NotNull
	@Max(value = 900000000)
	private Integer basicSalary;

	/**
	 * 役職手当
	 */
	private Integer jobAllowance;

	/**
	 * 資格手当
	 */
	private Integer requirementsAllowance;

	/**
	 * 住宅手当
	 */
	private Integer housingAllowance;

	/**
	 * 家族手当
	 */
	private Integer familyAllowance;

	/**
	 * その他の手当
	 */
	private Integer otherAllowance;

	/**
	 * 非課税交通費
	 */
	private Integer taxExpense;

	/**
	 * 旅行積立金
	 */
	private Integer travelFund;

	/**
	 * 借入等返済
	 */
	private Integer repaymentBorrowings;

	/**
	 * その他の控除
	 */
	private Integer otherDeductions;

	/**
	 * @return creationflag
	 */
	public boolean isCreationflag() {
		return creationflag;
	}

	/**
	 * @param creationflag
	 *            セットする creationflag
	 */
	public void setCreationflag(boolean creationflag) {
		this.creationflag = creationflag;
	}

	/**
	 * @return employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo
	 *            セットする employeeNo
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

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
	 * @return firstNameKana
	 */
	public String getFirstNameKana() {
		return firstNameKana;
	}

	/**
	 * @param firstNameKana
	 *            セットする firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	/**
	 * @return lastNameKana
	 */
	public String getLastNameKana() {
		return lastNameKana;
	}

	/**
	 * @param lastNameKana
	 *            セットする lastNameKana
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            セットする lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            セットする sex
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return department
	 */
	public Integer getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            セットする department
	 */
	public void setDepartment(Integer department) {
		this.department = department;
	}

	/**
	 * @return departmentList
	 */
	public List<TCompanyDepartment> getDepartmentList() {
		return departmentList;
	}

	/**
	 * @param departmentList
	 *            セットする departmentList
	 */
	public void setDepartmentList(List<TCompanyDepartment> departmentList) {
		this.departmentList = departmentList;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return accountHolder
	 */
	public String getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @param accountHolder
	 *            セットする accountHolder
	 */
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * @return bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode
	 *            セットする bankCode
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            セットする bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return accountType
	 */
	public Integer getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            セットする accountType
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            セットする branchCode
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            セットする branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            セットする accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return incomeTaxDistinction
	 */
	public Integer getIncomeTaxDistinction() {
		return incomeTaxDistinction;
	}

	/**
	 * @param incomeTaxDistinction
	 *            セットする incomeTaxDistinction
	 */
	public void setIncomeTaxDistinction(Integer incomeTaxDistinction) {
		this.incomeTaxDistinction = incomeTaxDistinction;
	}

	/**
	 * @return consort
	 */
	public Integer getConsort() {
		return consort;
	}

	/**
	 * @param consort
	 *            セットする consort
	 */
	public void setConsort(Integer consort) {
		this.consort = consort;
	}

	/**
	 * @return dependents
	 */
	public Integer getDependents() {
		return dependents;
	}

	/**
	 * @param dependents
	 *            セットする dependents
	 */
	public void setDependents(Integer dependents) {
		this.dependents = dependents;
	}

	/**
	 * @return dependentsNumber
	 */
	public Integer getDependentsNumber() {
		return dependentsNumber;
	}

	/**
	 * @param dependentsNumber
	 *            セットする dependentsNumber
	 */
	public void setDependentsNumber(Integer dependentsNumber) {
		this.dependentsNumber = dependentsNumber;
	}

	/**
	 * @return householdName
	 */
	public String getHouseholdName() {
		return householdName;
	}

	/**
	 * @param householdName
	 *            セットする householdName
	 */
	public void setHouseholdName(String householdName) {
		this.householdName = householdName;
	}

	/**
	 * @return relationship
	 */
	public String getRelationship() {
		return relationship;
	}

	/**
	 * @param relationship
	 *            セットする relationship
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	/**
	 * @return treatyExemption
	 */
	public Boolean getTreatyExemption() {
		return treatyExemption;
	}

	/**
	 * @param treatyExemption
	 *            セットする treatyExemption
	 */
	public void setTreatyExemption(Boolean treatyExemption) {
		this.treatyExemption = treatyExemption;
	}

	/**
	 * @return blueOfficer
	 */
	public Boolean getBlueOfficer() {
		return blueOfficer;
	}

	/**
	 * @param blueOfficer
	 *            セットする blueOfficer
	 */
	public void setBlueOfficer(Boolean blueOfficer) {
		this.blueOfficer = blueOfficer;
	}

	/**
	 * @return insuranceFlag
	 */
	public Short getInsuranceFlag() {
		return insuranceFlag;
	}

	/**
	 * @param insuranceFlag
	 *            セットする insuranceFlag
	 */
	public void setInsuranceFlag(Short insuranceFlag) {
		this.insuranceFlag = insuranceFlag;
	}

	/**
	 * @return healthInsuranceFlag
	 */
	public Short getHealthInsuranceFlag() {
		return healthInsuranceFlag;
	}

	/**
	 * @param healthInsuranceFlag
	 *            セットする healthInsuranceFlag
	 */
	public void setHealthInsuranceFlag(Short healthInsuranceFlag) {
		this.healthInsuranceFlag = healthInsuranceFlag;
	}

	/**
	 * @return healthInsuranceType
	 */
	public Short getHealthInsuranceType() {
		return healthInsuranceType;
	}

	/**
	 * @param healthInsuranceType
	 *            セットする healthInsuranceType
	 */
	public void setHealthInsuranceType(Short healthInsuranceType) {
		this.healthInsuranceType = healthInsuranceType;
	}

	/**
	 * @return healthCompensation
	 */
	public Short getHealthCompensation() {
		return healthCompensation;
	}

	/**
	 * @param healthCompensation
	 *            セットする healthCompensation
	 */
	public void setHealthCompensation(Short healthCompensation) {
		this.healthCompensation = healthCompensation;
	}

	/**
	 * @return insurerNumber
	 */
	public Long getInsurerNumber() {
		return insurerNumber;
	}

	/**
	 * @param insurerNumber
	 *            セットする insurerNumber
	 */
	public void setInsurerNumber(Long insurerNumber) {
		this.insurerNumber = insurerNumber;
	}

	/**
	 * @return insuredPersonnelNumber
	 */
	public Long getInsuredPersonnelNumber() {
		return insuredPersonnelNumber;
	}

	/**
	 * @param insuredPersonnelNumber
	 *            セットする insuredPersonnelNumber
	 */
	public void setInsuredPersonnelNumber(Long insuredPersonnelNumber) {
		this.insuredPersonnelNumber = insuredPersonnelNumber;
	}

	/**
	 * @return welfarePensionFlag
	 */
	public Integer getWelfarePensionFlag() {
		return welfarePensionFlag;
	}

	/**
	 * @param welfarePensionFlag
	 *            セットする welfarePensionFlag
	 */
	public void setWelfarePensionFlag(Integer welfarePensionFlag) {
		this.welfarePensionFlag = welfarePensionFlag;
	}

	/**
	 * @return welfareCompensation
	 */
	public Short getWelfareCompensation() {
		return welfareCompensation;
	}

	/**
	 * @param welfareCompensation
	 *            セットする welfareCompensation
	 */
	public void setWelfareCompensation(Short welfareCompensation) {
		this.welfareCompensation = welfareCompensation;
	}

	/**
	 * @return welfareNumber
	 */
	public Long getWelfareNumber() {
		return welfareNumber;
	}

	/**
	 * @param welfareNumber
	 *            セットする welfareNumber
	 */
	public void setWelfareNumber(Long welfareNumber) {
		this.welfareNumber = welfareNumber;
	}

	/**
	 * @return welfareFund
	 */
	public Integer getWelfareFund() {
		return welfareFund;
	}

	/**
	 * @param welfareFund
	 *            セットする welfareFund
	 */
	public void setWelfareFund(Integer welfareFund) {
		this.welfareFund = welfareFund;
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
	 * @return jobAllowance
	 */
	public Integer getJobAllowance() {
		return jobAllowance;
	}

	/**
	 * @param jobAllowance
	 *            セットする jobAllowance
	 */
	public void setJobAllowance(Integer jobAllowance) {
		this.jobAllowance = jobAllowance;
	}

	/**
	 * @return requirementsAllowance
	 */
	public Integer getRequirementsAllowance() {
		return requirementsAllowance;
	}

	/**
	 * @param requirementsAllowance
	 *            セットする requirementsAllowance
	 */
	public void setRequirementsAllowance(Integer requirementsAllowance) {
		this.requirementsAllowance = requirementsAllowance;
	}

	/**
	 * @return housingAllowance
	 */
	public Integer getHousingAllowance() {
		return housingAllowance;
	}

	/**
	 * @param housingAllowance
	 *            セットする housingAllowance
	 */
	public void setHousingAllowance(Integer housingAllowance) {
		this.housingAllowance = housingAllowance;
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
	 * @return taxExpense
	 */
	public Integer getTaxExpense() {
		return taxExpense;
	}

	/**
	 * @param taxExpense
	 *            セットする taxExpense
	 */
	public void setTaxExpense(Integer taxExpense) {
		this.taxExpense = taxExpense;
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
	 * @return otherDeductions
	 */
	public Integer getOtherDeductions() {
		return otherDeductions;
	}

	/**
	 * @param otherDeductions
	 *            セットする otherDeductions
	 */
	public void setOtherDeductions(Integer otherDeductions) {
		this.otherDeductions = otherDeductions;
	}

}
