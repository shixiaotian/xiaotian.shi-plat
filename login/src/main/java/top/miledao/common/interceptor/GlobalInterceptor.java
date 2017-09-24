package top.miledao.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.miledao.plat.vo.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaotian.shi on 2017/6/1.
 */
public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        this.createSession(httpServletRequest);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    // 拦截session 创建session 对象
    private void createSession(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();

        Object loginUserObject = session.getAttribute("loginUser");

        if(loginUserObject == null) {

            LoginUser loginUser = new LoginUser();
            // 设置错误登陆极限次数
            loginUser.setLoginFailTimes(3);
            session.setAttribute("loginUser", loginUser);
        }

    }
}
