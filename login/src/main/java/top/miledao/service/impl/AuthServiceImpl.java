package top.miledao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.miledao.service.intf.AuthService;
import top.miledao.service.intf.PageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaotian.shi on 2017/7/30.
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {

    // 临时权限数据
    private Map<String, List<String>> authData;

    @Autowired
    private PageService pageService;

    @Override
    // 构造临时权限数据
    public Map<String, List<String>> getAuthData() {

        if(authData == null) {

            authData = new HashMap<>();

            authData.put("admin", this.getAdmin());
            authData.put("user1", this.getUser1());
            authData.put("user2", this.getUser2());

        }

        return authData;

    }

    // admin
    private List<String> getAdmin() {

        List<String> admin = new ArrayList<>();

        if("dev".equals(pageService.getEnv())) {

            admin.add("www.xiaotiandev.shi");
            admin.add("portal.xiaotiandev.shi");
            admin.add("monitor.xiaotiandev.shi");

        } else {

            admin.add("portal.xiaotian.shi");
            admin.add("monitor.xiaotian.shi");
        }

        return admin;

    }

    // user1
    private List<String> getUser1() {

        List<String> user1 = new ArrayList<>();

        if("dev".equals(pageService.getEnv())) {

            user1.add("www.xiaotiandev.shi");
            user1.add("monitor.xiaotiandev.shi");

        } else {

            user1.add("monitor.xiaotian.shi");
        }

        return user1;

    }

    // user2
    private List<String> getUser2() {

        List<String> user2 = new ArrayList<>();

        if("dev".equals(pageService.getEnv())) {

            user2.add("www.xiaotiandev.shi");
            user2.add("portal.xiaotiandev.shi");

        } else {

            user2.add("portal.xiaotian.shi");

        }

        return user2;

    }
}
