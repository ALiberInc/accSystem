package jp.co.aliber.accsystem.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_login_user", schema = "public")
public class MLoginUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	@Column(name = "login_id", unique = true)
	private String loginId;

	@Column(name = "password")
	private String password;

	@Column(name = "comp_id")
	private Integer compId;

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

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}
}
