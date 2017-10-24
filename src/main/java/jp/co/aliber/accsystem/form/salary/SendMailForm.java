package jp.co.aliber.accsystem.form.salary;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SendMailForm {

	/**
	 * メールアドレス
	 */
	@NotBlank
	@Size(max = 100)
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9_./?+\\-]+[a-zA-Z0-9_./?+\\-@]+$")
	private String sendMailStr;

	/**
	 * 作成方法
	 */
	private int bodyType;

	/**
	 * 件名
	 */
	private String mailName;

	/**
	 * 従業員名
	 */
	private String employeeName;

	/**
	 * 会社名
	 */
	private String compName;

	/**
	 * 会社アドレース
	 */
	private String compAddress;

	/**
	 * 会社電話
	 */
	private String compTel;

	/**
	 * 年
	 */
	private String salaryYear;

	/**
	 * 月
	 */
	private String salaryMonth;

	/**
	 * @return sendMailStr
	 */
	public String getSendMailStr() {
		return sendMailStr;
	}

	/**
	 * @param sendMailStr
	 *            セットする sendMailStr
	 */
	public void setSendMailStr(String sendMailStr) {
		this.sendMailStr = sendMailStr;
	}

	/**
	 * @return bodyType
	 */
	public int getBodyType() {
		return bodyType;
	}

	/**
	 * @param bodyType
	 *            セットする bodyType
	 */
	public void setBodyType(int bodyType) {
		this.bodyType = bodyType;
	}

	/**
	 * @return mailName
	 */
	public String getMailName() {
		return mailName;
	}

	/**
	 * @param mailName
	 *            セットする mailName
	 */
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	/**
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            セットする employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return compName
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * @param compName
	 *            セットする compName
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}

	/**
	 * @return compAddress
	 */
	public String getCompAddress() {
		return compAddress;
	}

	/**
	 * @param compAddress
	 *            セットする compAddress
	 */
	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	/**
	 * @return compTel
	 */
	public String getCompTel() {
		return compTel;
	}

	/**
	 * @param compTel
	 *            セットする compTel
	 */
	public void setCompTel(String compTel) {
		this.compTel = compTel;
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

}
