package jp.co.aliber.accsystem.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * ユーザ情報
 * 
 * @author yu_k
 *
 */
public class LoginUserInfoForm {
	// 会社番号
	@NotNull
	private String compId;
	// 姓
	@NotNull
	@Size(max = 128)
	private String lastName;
	// 名
	@NotNull
	@Size(max = 128)
	private String firstName;
	// 姓カナ
	@Size(max = 128) 
	@Pattern(regexp = "[ァ-ヶー]*")
	private String lastNameKana;
	// 名カナ
	@Size(max = 128)
	@Pattern(regexp = "[ァ-ヶー]*")
	private String firstNameKana;
	// アルファベット名
	@Size(max = 128)
	@Pattern(regexp = "[a-zA-Z0-9\\s_./?+\\-]*")
	private String alphabetName;
	// メールアドレス
	@NotNull
	@Size(max = 128)
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9_./?+\\-]+[a-zA-Z0-9_./?+\\-@]+$")
	private String email;
	// ログインID
	@NotNull
	@Size(max = 64)
	private String loginId;
	// 暗証番号
	@NotNull
	@Size(min = 5, max = 128)
	@Pattern(regexp = "[a-zA-Z0-9\\]\\[!\"#$%&|\'()*+,-./:;<=>?@^_`{|}~\\\\]*")
	private String password;


	/**
	 * @return compId
	 */
	public String getCompId() {
		return compId;
	}


	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @return lastNameKana
	 */
	public String getLastNameKana() {
		return lastNameKana;
	}


	/**
	 * @return firstNameKana
	 */
	public String getFirstNameKana() {
		return firstNameKana;
	}


	/**
	 * @return alphabetName
	 */
	public String getAlphabetName() {
		return alphabetName;
	}


	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}


	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param compId
	 *            セットする compId
	 */
	public void setCompId(String compId) {
		this.compId = compId;
	}


	/**
	 * @param lastName
	 *            セットする lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @param firstName
	 *            セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @param lastNameKana
	 *            セットする lastNameKana
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}


	/**
	 * @param firstNameKana
	 *            セットする firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}


	/**
	 * @param alphabetName
	 *            セットする alphabetName
	 */
	public void setAlphabetName(String alphabetName) {
		this.alphabetName = alphabetName;
	}


	/**
	 * @param email
	 *            セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @param loginId
	 *            セットする loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	/**
	 * @param password
	 *            セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
