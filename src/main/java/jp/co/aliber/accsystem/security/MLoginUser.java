package jp.co.aliber.accsystem.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_login_user", schema = "public")
public class MLoginUser implements java.io.Serializable {
	@Id
	private String loginId;
	private String password;
	@Column
	private String compId;

	public MLoginUser() {
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

}
