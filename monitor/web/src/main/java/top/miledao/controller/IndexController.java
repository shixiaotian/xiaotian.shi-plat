package top.miledao.controller;

/**
 * Created by xiaotian.shi on 2017/4/6.
 */

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import top.miledao.plat.vo.LoginUser;

import java.util.Map;


@Controller
@SessionAttributes({"loginUser"}) // 如果你需要所有的类都自动注入这个对象，请写一个父类，其他全继承就可以
public class IndexController {


    @RequestMapping("/")
    String home(LoginUser loginUser, Map<String, Object> map) {

        if(!StringUtils.isEmpty(loginUser.getUsername())) {
            map.put("username", "当前登陆用户：" + loginUser.getUsername());
        }

        return "index";
    }

}
