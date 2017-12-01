package jp.co.aliber.accsystem.form.salary;

import java.util.List;

import jp.co.aliber.accsystem.entity.EmployeeInfo;

public class SalaryStatementForm {

	private List<EmployeeInfo> employeeInfoList;

	private Integer compId;
	// 選択年
	private String salaryYear;
	// 選択月
	private String salaryMonth;

	/**
	 * 年リスト
	 */
	private List<String> yearList;

	/**
	 * 月リスト
	 */
	private List<String> monthList;

	/**
	 * @return employeeInfoList
	 */
	public List<EmployeeInfo> getEmployeeInfoList() {
		return employeeInfoList;
	}

	/**
	 * @param employeeInfoList セットする employeeInfoList
	 */
	public void setEmployeeInfoList(List<EmployeeInfo> employeeInfoList) {
		this.employeeInfoList = employeeInfoList;
	}

	/**
	 * @return compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @param compId
	 *            セットする compId
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @return salaryYear
	 */
	public String getSalaryYear() {
		return salaryYear;
	}

	/**
	 * @param salaryYear
	 *            セットする salaryYear
	 */
	public void setSalaryYear(String salaryYear) {
		this.salaryYear = salaryYear;
	}

	/**
	 * @return salaryMonth
	 */
	public String getSalaryMonth() {
		return salaryMonth;
	}

	/**
	 * @param salaryMonth
	 *            セットする salaryMonth
	 */
	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

	/**
	 * @return yearList
	 */
	public List<String> getYearList() {
		return yearList;
	}

	/**
	 * @param yearList
	 *            セットする yearList
	 */
	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	/**
	 * @return monthList
	 */
	public List<String> getMonthList() {
		return monthList;
	}

	/**
	 * @param monthList
	 *            セットする monthList
	 */
	public void setMonthList(List<String> monthList) {
		this.monthList = monthList;
	}

}
