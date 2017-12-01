package jp.co.aliber.accsystem.form.employee;

import java.util.List;

import jp.co.aliber.accsystem.entity.EmployeeInfo;

public class EmployeeInfoForm {

	private List<EmployeeInfo> employeeInfoList;

	/**
	 * @return employeeInfoList
	 */
	public List<EmployeeInfo> getEmployeeInfoList() {
		return employeeInfoList;
	}

	/**
	 * @param employeeInfoList
	 *            セットする employeeInfoList
	 */
	public void setEmployeeInfoList(List<EmployeeInfo> employeeInfoList) {
		this.employeeInfoList = employeeInfoList;
	}

}
