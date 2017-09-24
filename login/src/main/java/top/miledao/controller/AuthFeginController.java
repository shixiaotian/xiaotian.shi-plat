package top.miledao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.miledao.service.intf.AuthService;
import top.miledao.service.intf.PageService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 权限远程调用接口
 *
 * Created by xiaotian.shi on 2017/7/28.
 */
@Controller
public class AuthFeginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthService authService;

    @Value("${app.server.hosts}")
    private String appServer;


    @RequestMapping(value = {"/auth"}, method={RequestMethod.POST})
    @ResponseBody
    public boolean check(
            @RequestParam("loginId") String loginId,
            @RequestParam("target") String target
    ) {

        logger.info("账号访问{} 目标 {}", loginId, target);



        Map<String, List<String>> data = authService.getAuthData();
        if(StringUtils.isEmpty(target)) {
            return false;
        }

        URL targetUrl = null;

        try {
            targetUrl = new URL(target);
        } catch (MalformedURLException e) {

            return false;

        }

        List<String> urlList = data.get(loginId);

        if(CollectionUtils.isEmpty(urlList)) {
            return false;
        }

        boolean isPass = false;


        for(String passUrl : urlList) {
            // 应该在此将请求拆解成服务器和子路径两个部分，分别鉴别权限
            String targetServer =targetUrl.getHost();

            if(targetServer.equals(passUrl)) {
                isPass = true;
            }

        }

        return isPass;

    }

    @RequestMapping(value = {"/auth/host"}, method={RequestMethod.POST})
    @ResponseBody
    public String getAuthHost() {

        return appServer;

    }

}
