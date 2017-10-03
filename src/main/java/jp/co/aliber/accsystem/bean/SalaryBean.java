package jp.co.aliber.accsystem.bean;

import org.apache.commons.collections.FastHashMap;

public class SalaryBean {
    /** 氏名. */
    private String name;

    /** 所属. */
    private String department;

    /** コード. */
    private String code;

    /** 支給年. */
    private String year;

    /** 支給月. */
    private String month;

    /** 支給日. */
    private String day;

    /** 出勤日数. */
    private String daysAttendance;

    /** 勤務時間. */
    private String workingHours;

    /** 時間外手当. */
    private String overtimeAllowance;

    /** 深夜労働. */
    private String lateNightLabor;

    /** 深夜残業. */
    private String lateNightOvertime;

    /** 休日出勤. */
    private String holidayWork;

    /** 休日残業. */
    private String restDay;

    /** 欠勤. */
    private String absence;

    /** 遅刻. */
    private String late;

    /** 早退. */
    private String leaveEarly;

    /** 税額表. */
    private String taxSchedule;

    /** 扶養人数. */
    private String numberOfDependents;

    /** 基本給. */
    private String basicSalary;

    /** 役職手当. */
    private String jobAllowance;

    /** 資格手当. */
    private String qualificationAllowance;

    /** 住宅手当. */
    private String housingAllowance;

    /** 家族手当. */
    private String familyAllowance;

    /** 交通費. */
    private String transportationCosts;

    /** その他の手当. */
    private String otherAllowance;

    /** 支給合計. */
    private String totalSupply;

    /** 健康保険. */
    private String healthInsurance;

    /**厚生年金. */
    private String welfareInsurance;

    /**雇用保険. */
    private String employInsurance;

    /** 所得税. */
    private String incomeTax;

    /** 住名税. */
    private String livingTax;

    /** 年末控除. */
    private String yearendDeduction;

    /** 家賃控除. */
    private String rentDeduction;

    /** 積立金. */
    private String accumulateGold;

    /** 借入等返済. */
    private String repaymentOfBorrowings;

    /** その他の控除. */
    private String otherDeductions;

    /** その他の控除. */
    private String allOtherDeductions;

    /** 控除合計. */
    private String totalDeduction;

    /** 差引支給額. */
    private String subscriptionAmount;

    /** 振込支給額. */
    private String transferPaymentAmount;

    /** 振込支給額合計. */
    private String totaltransferPaymentAmount;

    /** 現金支給額. */
    private String cashPaymentAmount;

    /** 現物支給額. */
    private String inkindPaymentAmount;

    /** 累計課税支給額. */
    private String cumulativeTaxableAmount;

    /** 累計社会保険料. */
    private String cumulativeSocialInsurancePremium;

    /** 累計所得税. */
    private String cumulativeIncomeTax;


    /**
     * 帳票用HashMap.<BR>
     * JasperReportsのテンプレートのパラメータに使用する
     */
    private FastHashMap map = new FastHashMap();

    /** コンストラクタ. */
    public SalaryBean() {
    }


    /**
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name セットする name
     */
    public void setName(String name) {
        this.name = name;
        map.put("name", this.name);
    }


    /**
     * @return department
     */
    public String getDepartment() {
        return department;
    }


    /**
     * @param department セットする department
     */
    public void setDepartment(String department) {
        this.department = department;
        map.put("department", this.department);
    }


    /**
     * @return code
     */
    public String getCode() {
        return code;
    }


    /**
     * @param code セットする code
     */
    public void setCode(String code) {
        this.code = code;
        map.put("code", this.code);
    }


    /**
     * @return year
     */
    public String getYear() {
        return year;
    }


    /**
     * @param year セットする year
     */
    public void setYear(String year) {
        this.year = year;
        map.put("year", this.year);
    }


    /**
     * @return month
     */
    public String getMonth() {
        return month;
    }


    /**
     * @param month セットする month
     */
    public void setMonth(String month) {
        this.month = month;
        map.put("month", this.month);
    }


    /**
     * @return day
     */
    public String getDay() {
        return day;
    }


    /**
     * @param day セットする day
     */
    public void setDay(String day) {
        this.day = day;
        map.put("day", this.day);
    }


    /**
     * @return daysAttendance
     */
    public String getDaysAttendance() {
        return daysAttendance;
    }


    /**
     * @param daysAttendance セットする daysAttendance
     */
    public void setDaysAttendance(String daysAttendance) {
        this.daysAttendance = daysAttendance;
        map.put("daysAttendance", this.daysAttendance);
    }


    /**
     * @return workingHours
     */
    public String getWorkingHours() {
        return workingHours;
    }


    /**
     * @param workingHours セットする workingHours
     */
    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
        map.put("workingHours", this.workingHours);
    }


    /**
     * @return overtimeAllowance
     */
    public String getOvertimeAllowance() {
        return overtimeAllowance;
    }


    /**
     * @param overtimeAllowance セットする overtimeAllowance
     */
    public void setOvertimeAllowance(String overtimeAllowance) {
        this.overtimeAllowance = overtimeAllowance;
        map.put("overtimeAllowance", this.overtimeAllowance);
    }


    /**
     * @return lateNightLabor
     */
    public String getLateNightLabor() {
        return lateNightLabor;
    }


    /**
     * @param lateNightLabor セットする lateNightLabor
     */
    public void setLateNightLabor(String lateNightLabor) {
        this.lateNightLabor = lateNightLabor;
        map.put("lateNightLabor", this.lateNightLabor);
    }


    /**
     * @return lateNightOvertime
     */
    public String getLateNightOvertime() {
        return lateNightOvertime;
    }


    /**
     * @param lateNightOvertime セットする lateNightOvertime
     */
    public void setLateNightOvertime(String lateNightOvertime) {
        this.lateNightOvertime = lateNightOvertime;
        map.put("lateNightOvertime", this.lateNightOvertime);
    }


    /**
     * @return holidayWork
     */
    public String getHolidayWork() {
        return holidayWork;
    }


    /**
     * @param holidayWork セットする holidayWork
     */
    public void setHolidayWork(String holidayWork) {
        this.holidayWork = holidayWork;
        map.put("holidayWork", this.holidayWork);
    }


    /**
     * @return restDay
     */
    public String getRestDay() {
        return restDay;
    }


    /**
     * @param restDay セットする restDay
     */
    public void setRestDay(String restDay) {
        this.restDay = restDay;
        map.put("restDay", this.restDay);
    }


    /**
     * @return absence
     */
    public String getAbsence() {
        return absence;
    }


    /**
     * @param absence セットする absence
     */
    public void setAbsence(String absence) {
        this.absence = absence;
        map.put("absence", this.absence);
    }


    /**
     * @return late
     */
    public String getLate() {
        return late;
    }


    /**
     * @param late セットする late
     */
    public void setLate(String late) {
        this.late = late;
        map.put("late", this.late);
    }


    /**
     * @return leaveEarly
     */
    public String getLeaveEarly() {
        return leaveEarly;
    }


    /**
     * @param leaveEarly セットする leaveEarly
     */
    public void setLeaveEarly(String leaveEarly) {
        this.leaveEarly = leaveEarly;
        map.put("leaveEarly", this.leaveEarly);
    }


    /**
     * @return taxSchedule
     */
    public String getTaxSchedule() {
        return taxSchedule;
    }


    /**
     * @param taxSchedule セットする taxSchedule
     */
    public void setTaxSchedule(String taxSchedule) {
        this.taxSchedule = taxSchedule;
        map.put("taxSchedule", this.taxSchedule);
    }


    /**
     * @return numberOfDependents
     */
    public String getNumberOfDependents() {
        return numberOfDependents;
    }


    /**
     * @param numberOfDependents セットする numberOfDependents
     */
    public void setNumberOfDependents(String numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
        map.put("numberOfDependents", this.numberOfDependents);
    }


    /**
     * @return basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }


    /**
     * @param basicSalary セットする basicSalary
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
        map.put("basicSalary", this.basicSalary);
    }


    /**
     * @return jobAllowance
     */
    public String getJobAllowance() {
        return jobAllowance;
    }


    /**
     * @param jobAllowance セットする jobAllowance
     */
    public void setJobAllowance(String jobAllowance) {
        this.jobAllowance = jobAllowance;
        map.put("jobAllowance", this.jobAllowance);
    }


    /**
     * @return qualificationAllowance
     */
    public String getQualificationAllowance() {
        return qualificationAllowance;
    }


    /**
     * @param qualificationAllowance セットする qualificationAllowance
     */
    public void setQualificationAllowance(String qualificationAllowance) {
        this.qualificationAllowance = qualificationAllowance;
        map.put("qualificationAllowance", this.qualificationAllowance);
    }


    /**
     * @return housingAllowance
     */
    public String getHousingAllowance() {
        return housingAllowance;
    }


    /**
     * @param housingAllowance セットする housingAllowance
     */
    public void setHousingAllowance(String housingAllowance) {
        this.housingAllowance = housingAllowance;
        map.put("housingAllowance", this.housingAllowance);
    }


    /**
     * @return familyAllowance
     */
    public String getFamilyAllowance() {
        return familyAllowance;
    }


    /**
     * @param familyAllowance セットする familyAllowance
     */
    public void setFamilyAllowance(String familyAllowance) {
        this.familyAllowance = familyAllowance;
        map.put("familyAllowance", this.familyAllowance);
    }


    /**
     * @return transportationCosts
     */
    public String getTransportationCosts() {
        return transportationCosts;
    }


    /**
     * @param transportationCosts セットする transportationCosts
     */
    public void setTransportationCosts(String transportationCosts) {
        this.transportationCosts = transportationCosts;
        map.put("transportationCosts", this.transportationCosts);
    }


    /**
     * @return totalSupply
     */
    public String getTotalSupply() {
        return totalSupply;
    }


    /**
     * @param totalSupply セットする totalSupply
     */
    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
        map.put("totalSupply", this.totalSupply);
    }


    /**
     * @return incomeTax
     */
    public String getIncomeTax() {
        return incomeTax;
    }


    /**
     * @param incomeTax セットする incomeTax
     */
    public void setIncomeTax(String incomeTax) {
        this.incomeTax = incomeTax;
        map.put("incomeTax", this.incomeTax);
    }


    /**
     * @return accumulateGold
     */
    public String getAccumulateGold() {
        return accumulateGold;
    }


    /**
     * @param accumulateGold セットする accumulateGold
     */
    public void setAccumulateGold(String accumulateGold) {
        this.accumulateGold = accumulateGold;
        map.put("accumulateGold", this.accumulateGold);
    }


    /**
     * @return repaymentOfBorrowings
     */
    public String getRepaymentOfBorrowings() {
        return repaymentOfBorrowings;
    }


    /**
     * @param repaymentOfBorrowings セットする repaymentOfBorrowings
     */
    public void setRepaymentOfBorrowings(String repaymentOfBorrowings) {
        this.repaymentOfBorrowings = repaymentOfBorrowings;
        map.put("repaymentOfBorrowings", this.repaymentOfBorrowings);
    }


    /**
     * @return otherDeductions
     */
    public String getOtherDeductions() {
        return otherDeductions;
    }


    /**
     * @param otherDeductions セットする otherDeductions
     */
    public void setOtherDeductions(String otherDeductions) {
        this.otherDeductions = otherDeductions;
        map.put("otherDeductions", this.otherDeductions);
    }


    /**
     * @return totalDeduction
     */
    public String getTotalDeduction() {
        return totalDeduction;
    }


    /**
     * @param totalDeduction セットする totalDeduction
     */
    public void setTotalDeduction(String totalDeduction) {
        this.totalDeduction = totalDeduction;
        map.put("totalDeduction", this.totalDeduction);
    }


    /**
     * @return subscriptionAmount
     */
    public String getSubscriptionAmount() {
        return subscriptionAmount;
    }


    /**
     * @param subscriptionAmount セットする subscriptionAmount
     */
    public void setSubscriptionAmount(String subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
        map.put("subscriptionAmount", this.subscriptionAmount);
    }


    /**
     * @return transferPaymentAmount
     */
    public String getTransferPaymentAmount() {
        return transferPaymentAmount;
    }


    /**
     * @param transferPaymentAmount セットする transferPaymentAmount
     */
    public void setTransferPaymentAmount(String transferPaymentAmount) {
        this.transferPaymentAmount = transferPaymentAmount;
        map.put("transferPaymentAmount", this.transferPaymentAmount);
    }


    /**
     * @return totaltransferPaymentAmount
     */
    public String getTotaltransferPaymentAmount() {
        return totaltransferPaymentAmount;
    }


    /**
     * @param totaltransferPaymentAmount セットする totaltransferPaymentAmount
     */
    public void setTotaltransferPaymentAmount(String totaltransferPaymentAmount) {
        this.totaltransferPaymentAmount = totaltransferPaymentAmount;
        map.put("totaltransferPaymentAmount", this.totaltransferPaymentAmount);
    }


    /**
     * @return cashPaymentAmount
     */
    public String getCashPaymentAmount() {
        return cashPaymentAmount;
    }


    /**
     * @param cashPaymentAmount セットする cashPaymentAmount
     */
    public void setCashPaymentAmount(String cashPaymentAmount) {
        this.cashPaymentAmount = cashPaymentAmount;
        map.put("cashPaymentAmount", this.cashPaymentAmount);
    }


    /**
     * @return inkindPaymentAmount
     */
    public String getInkindPaymentAmount() {
        return inkindPaymentAmount;
    }


    /**
     * @param inkindPaymentAmount セットする inkindPaymentAmount
     */
    public void setInkindPaymentAmount(String inkindPaymentAmount) {
        this.inkindPaymentAmount = inkindPaymentAmount;
        map.put("inkindPaymentAmount", this.inkindPaymentAmount);
    }


    /**
     * @return cumulativeTaxableAmount
     */
    public String getCumulativeTaxableAmount() {
        return cumulativeTaxableAmount;
    }


    /**
     * @param cumulativeTaxableAmount セットする cumulativeTaxableAmount
     */
    public void setCumulativeTaxableAmount(String cumulativeTaxableAmount) {
        this.cumulativeTaxableAmount = cumulativeTaxableAmount;
        map.put("cumulativeTaxableAmount", this.cumulativeTaxableAmount);
    }


    /**
     * @return cumulativeSocialInsurancePremium
     */
    public String getCumulativeSocialInsurancePremium() {
        return cumulativeSocialInsurancePremium;
    }


    /**
     * @param cumulativeSocialInsurancePremium セットする cumulativeSocialInsurancePremium
     */
    public void setCumulativeSocialInsurancePremium(String cumulativeSocialInsurancePremium) {
        this.cumulativeSocialInsurancePremium = cumulativeSocialInsurancePremium;
        map.put("cumulativeSocialInsurancePremium", this.cumulativeSocialInsurancePremium);
    }


    /**
     * @return cumulativeIncomeTax
     */
    public String getCumulativeIncomeTax() {
        return cumulativeIncomeTax;
    }


    /**
     * @param cumulativeIncomeTax セットする cumulativeIncomeTax
     */
    public void setCumulativeIncomeTax(String cumulativeIncomeTax) {
        this.cumulativeIncomeTax = cumulativeIncomeTax;
        map.put("cumulativeIncomeTax", this.cumulativeIncomeTax);
    }


    /**
     * @return map
     */
    public FastHashMap getMap() {
        return map;
    }


    /**
     * @return otherAllowance
     */
    public String getOtherAllowance() {
        return otherAllowance;
    }


    /**
     * @param otherAllowance セットする otherAllowance
     */
    public void setOtherAllowance(String otherAllowance) {
        this.otherAllowance = otherAllowance;
    }


    /**
     * @return healthInsurance
     */
    public String getHealthInsurance() {
        return healthInsurance;
    }


    /**
     * @param healthInsurance セットする healthInsurance
     */
    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }


    /**
     * @return welfareInsurance
     */
    public String getWelfareInsurance() {
        return welfareInsurance;
    }


    /**
     * @param welfareInsurance セットする welfareInsurance
     */
    public void setWelfareInsurance(String welfareInsurance) {
        this.welfareInsurance = welfareInsurance;
    }


    /**
     * @return employInsurance
     */
    public String getEmployInsurance() {
        return employInsurance;
    }


    /**
     * @param employInsurance セットする employInsurance
     */
    public void setEmployInsurance(String employInsurance) {
        this.employInsurance = employInsurance;
    }


    /**
     * @return livingTax
     */
    public String getLivingTax() {
        return livingTax;
    }


    /**
     * @param livingTax セットする livingTax
     */
    public void setLivingTax(String livingTax) {
        this.livingTax = livingTax;
    }


    /**
     * @return yearendDeduction
     */
    public String getYearendDeduction() {
        return yearendDeduction;
    }


    /**
     * @param yearendDeduction セットする yearendDeduction
     */
    public void setYearendDeduction(String yearendDeduction) {
        this.yearendDeduction = yearendDeduction;
    }


    /**
     * @return rentDeduction
     */
    public String getRentDeduction() {
        return rentDeduction;
    }


    /**
     * @param rentDeduction セットする rentDeduction
     */
    public void setRentDeduction(String rentDeduction) {
        this.rentDeduction = rentDeduction;
    }


    /**
     * @return allOtherDeductions
     */
    public String getAllOtherDeductions() {
        return allOtherDeductions;
    }


    /**
     * @param allOtherDeductions セットする allOtherDeductions
     */
    public void setAllOtherDeductions(String allOtherDeductions) {
        this.allOtherDeductions = allOtherDeductions;
    }
}
