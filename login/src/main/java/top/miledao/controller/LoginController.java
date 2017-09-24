package top.miledao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.miledao.common.BaseController;
import top.miledao.vo.JsonResponse;
import top.miledao.plat.vo.LoginUser;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xiaotian.shi on 2017/7/15.
 */
@Controller
public class LoginController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    private Map<String, String> user;

    @RequestMapping(value = {"/login"}, method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResponse login(
                                LoginUser loginUser,
                              @RequestParam(value="username", required=false) String loginId,
                              @RequestParam(value="password", required=false) String password,
                              @RequestParam(value="captchaCode", required=false) String captchaCode
                              ) {
        if(StringUtils.isEmpty(captchaCode)) {
            return this.printFail("请输入验证码");
        }

        // 验证码多次错误，直接放弃当前token 新开
        if(loginUser.getLoginFailTimes() <= 0) {

            loginUser.setLoginFailTimes(3);
            return this.printFail("错误次数太多，验证码已更新", 202);
        }

        if(loginId == null && password == null) {
            return this.printFail("请输入用户明和密码");
        }

        if(!this.hasUser(loginId)) {
            return this.printFail("用户不存在");
        }

        String loginIdPass = this.getPass(loginId);

        if(loginIdPass.equals(password)) {

            // 校验验证码
            if(!captchaCode.equals(loginUser.getLoginToken())) {
                loginUser.setLoginFailTimes(loginUser.getLoginFailTimes() - 1);
                return this.printFail("验证码错误");
            }

            loginUser.setUsername(loginId);
            loginUser.setLoginId(loginId);
            loginUser.setLogin(true);
            loginUser.setLoginToken(null);

            return this.printSuccess();
        } else {
            loginUser.setLoginToken(null);
            return this.printFail("用户名或密码错误");
        }

    }

    @RequestMapping(value = {"/logout"}, method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResponse login(LoginUser loginUser) {

        String token = UUID.randomUUID().toString();
//        loginUser =  new LoginUser();
        loginUser.setLogin(false);
        loginUser.setLoginToken(token);
        loginUser.setUsername(null);

        return this.printSuccess();

    }

    private String getPass(String loginId) {

        String pass = this.getUser().get(loginId);

        if(StringUtils.isEmpty(pass)) {
            return UUID.randomUUID().toString();
        } else {
            return pass;
        }

    }

    // 虚拟账户密码，需要做到数据库
    private Map<String, String> getUser() {

        if(user == null) {

            user = new HashMap<>();

            user.put("admin", "admin");
            user.put("user1", "user1");
            user.put("user2", "user2");

        }

        return user;

    }

    // 检查用户是否存在
    private boolean hasUser(String loginId) {

        String pass = this.getUser().get(loginId);

        if(StringUtils.isEmpty(pass)) {
            return false;
        } else {
            return true;
        }


    }

}
