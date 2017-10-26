package jp.co.aliber.accsystem.entity;

import jp.co.aliber.accsystem.entity.auto.TEmployee;

public class EmployeeInfo extends TEmployee {

	/**
	 * 所属名
	 */
	private String deptName;

	/**
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName
	 *            セットする deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
