package jp.co.aliber.accsystem.form.user;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * ユーザ情報
 *
 * @author yu_k
 *
 */
public class RegisterForm {

	// 姓
	@NotBlank
	@Size(max = 50)
	private String lastName;

	// 名
	@NotBlank
	@Size(max = 50)
	private String firstName;

	// 姓カナ
	@Size(max = 50)
	@Pattern(regexp = "[ァ-ヶー]*")
	private String lastNameKana;

	// 名カナ
	@Size(max = 50)
	@Pattern(regexp = "[ァ-ヶー]*")
	private String firstNameKana;

	// アルファベット名
	@Size(max = 50)
	@Pattern(regexp = "[A-Za-z ]*")
	private String alphabetName;

	// メールアドレス
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	// ログインID
	@NotBlank
	@Size(max = 50)
	@Pattern(regexp = "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$")
	private String loginId;

	// 暗証番号
	@NotBlank
	@Size(min = 5, max = 50)
	@Pattern(regexp = "[a-zA-Z0-9\\]\\[!\"#$%&|\'()*+,-./:;<=>?@^_`{|}~\\\\]*")
	private String password;

	// 暗証番号(確認)
	@NotBlank
	private String passwordConfirm;

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
