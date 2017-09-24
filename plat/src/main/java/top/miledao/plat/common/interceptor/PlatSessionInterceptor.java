package top.miledao.plat.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.miledao.plat.service.fegin.PlatAuthClient;
import top.miledao.plat.vo.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaotian.shi on 2017/7/15.
 */
public class PlatSessionInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String loginServer;

    @Autowired
    private PlatAuthClient authClient;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登陆的对象
        LoginUser loginUser = null;

        // 获取会话
        HttpSession session = request.getSession();

        Object loginUserObject = session.getAttribute("loginUser");

        // 获取请求地址
        String url = request.getRequestURL().toString();;

        String redirectUrl = this.getLoginServer() +"?redirect=" + url ;

        if(loginUserObject != null) {

            loginUser = (LoginUser) loginUserObject;


        } else {

            // 会话不存在不允许访问
            response.sendRedirect(redirectUrl);
            return false;
        }
        // 会话是否已经登陆
        if(Boolean.TRUE.equals(loginUser.isLogin())) {

            return true;
        } else {
            // 没有登陆
            // 会话未登陆
            response.sendRedirect(redirectUrl);
            return false;
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    private String getLoginServer() {

        if(StringUtils.isEmpty(loginServer)) {
            loginServer = authClient.getAuthHost();
        }

        return loginServer;

    }

}
