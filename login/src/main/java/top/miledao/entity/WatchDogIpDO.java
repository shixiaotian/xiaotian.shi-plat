package top.miledao.entity;

import top.miledao.common.CommonDO;

/**
 *
 * 看门狗记录访问记录
 *
 * Created by xiaotian.shi on 2017/6/14.
 */
public class WatchDogIpDO extends CommonDO {

    // ip地址
    private String ip;

    // url 访问地址
    private String url;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
