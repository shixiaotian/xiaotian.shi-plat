package top.miledao.plat.vo;

import java.io.Serializable;

/**
 *
 * 登陆的会话对象
 *
 * Created by xiaotian.shi on 2017/7/15.
 */
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1815005870302778057l;

    private String loginId;

    private String username;

    private boolean isLogin;

    private String loginToken;

    private Integer loginFailTimes;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Integer getLoginFailTimes() {

        if(loginFailTimes == null) {
            return 3;
        }

        return loginFailTimes;
    }

    public void setLoginFailTimes(Integer loginFailTimes) {
        this.loginFailTimes = loginFailTimes;
    }
}
