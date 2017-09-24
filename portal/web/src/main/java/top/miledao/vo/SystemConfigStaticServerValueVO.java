package top.miledao.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * 系统配置
 *
 * Created by xiaotian.shi on 2017/6/14.
 */
public class SystemConfigStaticServerValueVO {

    // 静态服务器地址
    private String url;

    // 单点登陆服务器地址
    private String loginServerUrl;

    // 是否可用
    private String isAvailable;

    // 静态资源版本
    private String version;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLoginServerUrl() {
        return loginServerUrl;
    }

    public void setLoginServerUrl(String loginServerUrl) {
        this.loginServerUrl = loginServerUrl;
    }
}
