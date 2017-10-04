package jp.co.aliber.accsystem.security.userdetails;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // ログインID
    private String loginId;
    // パスワード
    private String password;
    // ユーザID
    private Integer userId;
    // 会社ID
    private Integer compId;

    /**
     * @return loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId
     *            セットする loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return userId
     */
    public Integer getUserId() {
        return 1;
    }

    /**
     * @param userId
     *            セットする userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return compId
     */
    public Integer getCompId() {
        return 10;
    }

    /**
     * @param compId
     *            セットする compId
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
