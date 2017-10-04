package jp.co.aliber.accsystem.security.userdetails;

import java.io.Serializable;

public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private UserInfo userInfo = new UserInfo();

    /**
     * @return userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

}
