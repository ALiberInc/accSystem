package jp.co.aliber.accsystem.form.employee;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Pattern(regexp = "[0-9]*")
    private Integer employeeNo;

    /**
     * 従業員番号
     */
    @NotNull
    @Pattern(regexp = "[0-9]*")
    private Integer employeeId;

    /**
     * フリガナ
     */
    @Size(max = 50)
    @Pattern(regexp = "[ァ-ヶー]*")
    private String firstNameKana;

    /**
     * フリガナ
     */
    @Size(max = 50)
    @Pattern(regexp = "[ァ-ヶー]*")
    private String lastNameKana;

    /**
     * 氏名
     */
    @NotNull
    @Size(max = 50)
    private String firstName;

    /**
     * 氏名
     */
    @NotNull
    @Size(max = 50)
    private String lastName;

    /**
     * 性別
     */
    @NotNull
    private int sex;

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
     * 口座名義人
     */
    @NotNull
    @Size(max = 100)
    private String accountHolder;

    /**
     * 銀行コード
     */
    @NotNull
    @Size(max = 100)
    private Integer bankCode;

    /**
     * 銀行名
     */
    @NotNull
    @Size(max = 100)
    private String bankName;

    /**
     * 口座種別
     */
    @NotNull
    @Size(max = 10)
    private int accountType;


    /**
     * 本支店コード
     */
    @NotNull
    @Size(max = 10)
    private Integer branchCode;

    /**
     * 本支店名
     */
    @NotNull
    @Size(max = 100)
    private String branchName;

    /**
     * 口座番号
     */
    @NotNull
    @Size(max = 50)
    private Integer accountNumber;

    /**
     * 所得税区分
     */
    @NotNull
    private int incomeTaxDistinction;

    /**
     * 控除対象配偶者
     */
    @NotNull
    private int consort;

    /**
     * 扶養控除等の申告
     */
    @NotNull
    private int dependents;

    /**
     * 扶養人数
     */
    @NotNull
    @Pattern(regexp = "[0-9]*")
    private Integer dependentsNumber;

    /**
     * 世帯主名
     */
    @NotNull
    @Size(max = 100)
    private String householdName;

    /**
     * 続柄
     */
    @NotNull
    @Size(max = 50)
    private String relationship;

    /**
     * 条約免除
     */
    private boolean treatyExemption;

    /**
     * 青色専従者
     */
    private boolean blueOfficer;

    /**
     * 雇用保険
     */
    private int insuranceFlag;

    /**
     * 健康保険
     */
    private int healthInsuranceFlag;

    /**
     * 健康保険種別
     */
    private int healthInsuranceType;

    /**
     * 健康保険の標準報酬
     */
    private Integer healthCompensation;

    /**
     * 保険者番号
     */
    private Integer insurerNumber;

    /**
     * 被保険者整理番号
     */
    private Integer insuredPersonnelNumber;

    /**
     * 厚生年金
     */
    private int welfarePensionFlag;

    /**
     * 厚生年金の標準報酬
     */
    private Integer welfareCompensation;

    /**
     * 基礎年金番号
     */
    private Integer welfareNumber;

    /**
     * 厚生年金基金
     */
    private int welfareFund;

    /**
     * 基本給
     */
    @NotNull
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
     * 積立金
     */
    private Integer accumulateGold;

    /**
     * 借入等返済
     */
    private Integer repayment;

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
     * @param creationflag セットする creationflag
     */
    public void setCreationflag(boolean creationflag) {
        this.creationflag = creationflag;
    }

    /**
     * @return companyId
     */
    public Integer getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param companyId セットする companyId
     */
    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return firstNameKana
     */
    public String getFirstNameKana() {
        return firstNameKana;
    }

    /**
     * @param firstNameKana セットする firstNameKana
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
     * @param lastNameKana セットする lastNameKana
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
     * @param firstName セットする firstName
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
     * @param lastName セットする lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex セットする sex
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return accountHolder
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * @param accountHolder セットする accountHolder
     */
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    /**
     * @return bankCode
     */
    public Integer getBankCode() {
        return bankCode;
    }

    /**
     * @param bankCode セットする bankCode
     */
    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName セットする bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return accountType
     */
    public int getAccountType() {
        return accountType;
    }

    /**
     * @param accountType セットする accountType
     */
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    /**
     * @return branchCode
     */
    public Integer getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode セットする branchCode
     */
    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * @return branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName セットする branchName
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return accountNumber
     */
    public Integer getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber セットする accountNumber
     */
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return incomeTaxDistinction
     */
    public int getIncomeTaxDistinction() {
        return incomeTaxDistinction;
    }

    /**
     * @param incomeTaxDistinction セットする incomeTaxDistinction
     */
    public void setIncomeTaxDistinction(int incomeTaxDistinction) {
        this.incomeTaxDistinction = incomeTaxDistinction;
    }

    /**
     * @return consort
     */
    public int getConsort() {
        return consort;
    }

    /**
     * @param consort セットする consort
     */
    public void setConsort(int consort) {
        this.consort = consort;
    }

    /**
     * @return dependents
     */
    public int getDependents() {
        return dependents;
    }

    /**
     * @param dependents セットする dependents
     */
    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    /**
     * @return dependentsNumber
     */
    public Integer getDependentsNumber() {
        return dependentsNumber;
    }

    /**
     * @param dependentsNumber セットする dependentsNumber
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
     * @param householdName セットする householdName
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
     * @param relationship セットする relationship
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * @return treatyExemption
     */
    public boolean isTreatyExemption() {
        return treatyExemption;
    }

    /**
     * @param treatyExemption セットする treatyExemption
     */
    public void setTreatyExemption(boolean treatyExemption) {
        this.treatyExemption = treatyExemption;
    }

    /**
     * @return blueOfficer
     */
    public boolean isBlueOfficer() {
        return blueOfficer;
    }

    /**
     * @param blueOfficer セットする blueOfficer
     */
    public void setBlueOfficer(boolean blueOfficer) {
        this.blueOfficer = blueOfficer;
    }

    /**
     * @return insuranceFlag
     */
    public int getInsuranceFlag() {
        return insuranceFlag;
    }

    /**
     * @param insuranceFlag セットする insuranceFlag
     */
    public void setInsuranceFlag(int insuranceFlag) {
        this.insuranceFlag = insuranceFlag;
    }

    /**
     * @return healthInsuranceFlag
     */
    public int getHealthInsuranceFlag() {
        return healthInsuranceFlag;
    }

    /**
     * @param healthInsuranceFlag セットする healthInsuranceFlag
     */
    public void setHealthInsuranceFlag(int healthInsuranceFlag) {
        this.healthInsuranceFlag = healthInsuranceFlag;
    }

    /**
     * @return healthInsuranceType
     */
    public int getHealthInsuranceType() {
        return healthInsuranceType;
    }

    /**
     * @param healthInsuranceType セットする healthInsuranceType
     */
    public void setHealthInsuranceType(int healthInsuranceType) {
        this.healthInsuranceType = healthInsuranceType;
    }

    /**
     * @return healthCompensation
     */
    public Integer getHealthCompensation() {
        return healthCompensation;
    }

    /**
     * @param healthCompensation セットする healthCompensation
     */
    public void setHealthCompensation(Integer healthCompensation) {
        this.healthCompensation = healthCompensation;
    }

    /**
     * @return insurerNumber
     */
    public Integer getInsurerNumber() {
        return insurerNumber;
    }

    /**
     * @param insurerNumber セットする insurerNumber
     */
    public void setInsurerNumber(Integer insurerNumber) {
        this.insurerNumber = insurerNumber;
    }

    /**
     * @return insuredPersonnelNumber
     */
    public Integer getInsuredPersonnelNumber() {
        return insuredPersonnelNumber;
    }

    /**
     * @param insuredPersonnelNumber セットする insuredPersonnelNumber
     */
    public void setInsuredPersonnelNumber(Integer insuredPersonnelNumber) {
        this.insuredPersonnelNumber = insuredPersonnelNumber;
    }

    /**
     * @return welfarePensionFlag
     */
    public int getWelfarePensionFlag() {
        return welfarePensionFlag;
    }

    /**
     * @param welfarePensionFlag セットする welfarePensionFlag
     */
    public void setWelfarePensionFlag(int welfarePensionFlag) {
        this.welfarePensionFlag = welfarePensionFlag;
    }

    /**
     * @return welfareCompensation
     */
    public Integer getWelfareCompensation() {
        return welfareCompensation;
    }

    /**
     * @param welfareCompensation セットする welfareCompensation
     */
    public void setWelfareCompensation(Integer welfareCompensation) {
        this.welfareCompensation = welfareCompensation;
    }

    /**
     * @return welfareNumber
     */
    public Integer getWelfareNumber() {
        return welfareNumber;
    }

    /**
     * @param welfareNumber セットする welfareNumber
     */
    public void setWelfareNumber(Integer welfareNumber) {
        this.welfareNumber = welfareNumber;
    }

    /**
     * @return welfareFund
     */
    public int getWelfareFund() {
        return welfareFund;
    }

    /**
     * @param welfareFund セットする welfareFund
     */
    public void setWelfareFund(int welfareFund) {
        this.welfareFund = welfareFund;
    }

    /**
     * @return basicSalary
     */
    public Integer getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary セットする basicSalary
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
     * @param jobAllowance セットする jobAllowance
     */
    public void setJobAllowance(Integer jobAllowance) {
        this.jobAllowance = jobAllowance;
    }

    /**
     * @return housingAllowance
     */
    public Integer getHousingAllowance() {
        return housingAllowance;
    }

    /**
     * @param housingAllowance セットする housingAllowance
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
     * @param familyAllowance セットする familyAllowance
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
     * @param otherAllowance セットする otherAllowance
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
     * @param taxExpense セットする taxExpense
     */
    public void setTaxExpense(Integer taxExpense) {
        this.taxExpense = taxExpense;
    }

    /**
     * @return accumulateGold
     */
    public Integer getAccumulateGold() {
        return accumulateGold;
    }

    /**
     * @param accumulateGold セットする accumulateGold
     */
    public void setAccumulateGold(Integer accumulateGold) {
        this.accumulateGold = accumulateGold;
    }

    /**
     * @return repayment
     */
    public Integer getRepayment() {
        return repayment;
    }

    /**
     * @param repayment セットする repayment
     */
    public void setRepayment(Integer repayment) {
        this.repayment = repayment;
    }

    /**
     * @return otherDeductions
     */
    public Integer getOtherDeductions() {
        return otherDeductions;
    }

    /**
     * @param otherDeductions セットする otherDeductions
     */
    public void setOtherDeductions(Integer otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    /**
     * @return requirementsAllowance
     */
    public Integer getRequirementsAllowance() {
        return requirementsAllowance;
    }

    /**
     * @param requirementsAllowance セットする requirementsAllowance
     */
    public void setRequirementsAllowance(Integer requirementsAllowance) {
        this.requirementsAllowance = requirementsAllowance;
    }

    /**
     * @return department
     */
    public Integer getDepartment() {
        return department;
    }

    /**
     * @param department セットする department
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
     * @param departmentList セットする departmentList
     */
    public void setDepartmentList(List<TCompanyDepartment> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * @return employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId セットする employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}
