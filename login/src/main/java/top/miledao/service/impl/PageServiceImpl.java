package top.miledao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.miledao.service.intf.PageService;

/**
 * Created by xiaotian.shi on 2017/6/1.
 */
@Service("pageService")
public class PageServiceImpl implements PageService{

    @Value("${static.server.hosts}")
    private String staticServerhosts;

    @Value("${main.server.host}")
    private String mainServerHost;

    @Value("${spring.profiles.active}")
    private String env;

    // 静态资源版本
    private String staticVersion = String.valueOf(System.currentTimeMillis());

    @Override
    public String getStaticServerhosts() {
        return staticServerhosts ;
    }

    @Override
    public String getResource(String url) {

        // 研发环境动态获取
        if("dev".equals(env)) {
            return getStaticServerhosts() + url + "?v" + System.currentTimeMillis();
        }

        return getStaticServerhosts() + url + "?v" + getStaticVersion();
    }

    public void setStaticServerhosts(String staticServerhosts) {
        this.staticServerhosts = staticServerhosts;
    }


    public String getStaticVersion() {
        return staticVersion;
    }


    public String getMainServerHost() {
        return mainServerHost;
    }

    public void setMainServerHost(String mainServerHost) {
        this.mainServerHost = mainServerHost;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
