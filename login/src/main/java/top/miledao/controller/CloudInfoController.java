package top.miledao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.miledao.common.BaseController;
import top.miledao.entity.Navigation;
import top.miledao.service.intf.PageService;
import top.miledao.vo.JsonResponse;
import top.miledao.plat.vo.LoginUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaotian.shi on 2017/7/23.
 */
@Controller
public class CloudInfoController extends BaseController{

    @Autowired
    private PageService pageService;

    @RequestMapping(value = {"/cloudInfo"}, method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResponse cloudInfo(LoginUser loginUser) {

        String username = loginUser.getUsername();

        Map<String, Object> data = new HashMap<>();
        // 伪造数据
        data.put("indexAccessCount", "3456");
        data.put("username", username);
        data.put("nav", this.getNav(loginUser.getLoginId()));

        if(username != null) {
            return this.print("您已登陆",200, data);
        } else {
            return this.print("请登陆", 201, data);
        }

    }

    // 导航数据，可以将此数据做成服务，通过用户的权限动态生成
    // 生成策略也应该根据不同的环境生成不同的url
    // 需要将 协议，地址，端口分开来匹配
    private List<Navigation> getNav(String loginId) {

        List<Navigation> nav = new ArrayList<>();
        Navigation navigation1 = new Navigation();
        navigation1.setIndex(1);
        navigation1.setName("主站");


        Navigation navigation2 = new Navigation();
        navigation2.setIndex(2);
        navigation2.setName("管理站");


        Navigation navigation3 = new Navigation();
        navigation3.setIndex(3);
        navigation3.setName("监控站");


        String env = pageService.getEnv();

        if("dev".equals(env)) {
            navigation1.setUrl("http://www.xiaotiandev.shi:8082");
            navigation2.setUrl("http://portal.xiaotiandev.shi:8083");
            navigation3.setUrl("http://monitor.xiaotiandev.shi:8084");
        } else {
            navigation1.setUrl("http://www.xiaotian.shi");
            navigation2.setUrl("http://portal.xiaotian.shi");
            navigation3.setUrl("http://monitor.xiaotian.shi");
        }

        if("admin".equals(loginId)) {
            nav.add(navigation1);
            nav.add(navigation2);
            nav.add(navigation3);
        }

        if("user1".equals(loginId)) {
            nav.add(navigation1);
            nav.add(navigation3);
        }

        if("user2".equals(loginId)) {
            nav.add(navigation1);
            nav.add(navigation2);
        }

        return nav;
    }

}
