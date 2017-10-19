package jp.co.aliber.accsystem.form.salary;

import java.util.List;

import jp.co.aliber.accsystem.entity.auto.TEmployee;

public class SalaryStatementForm {

	private List<TEmployee> listTEmployee;

	private Integer compId;

	private String salaryYearMonth;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getSalaryYearMonth() {
		return salaryYearMonth;
	}

	public void setSalaryYearMonth(String salaryYearMonth) {
		this.salaryYearMonth = salaryYearMonth;
	}

	/**
	 * @return listTEmployee
	 */
	public List<TEmployee> getListTEmployee() {
		return listTEmployee;
	}

	/**
	 * @param listTEmployee
	 *            セットする listTEmployee
	 */
	public void setListTEmployee(List<TEmployee> listTEmployee) {
		this.listTEmployee = listTEmployee;
	}

}
