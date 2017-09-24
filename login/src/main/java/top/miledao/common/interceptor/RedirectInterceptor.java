package top.miledao.common.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiaotian.shi on 2017/7/15.
 */
public class RedirectInterceptor implements HandlerInterceptor {

    @Value("${login.server.hosts}")
    private String loginServer;

    @Value("${app.server.hosts}")
    private String appServer;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        // 获取请求地址
        String url = request.getRequestURL().toString();

        String redirectUrl = url.substring(url.indexOf("redirect="));

        // 重定向地址
        String newUrl = appServer;

        if(!StringUtils.isEmpty(redirectUrl)) {

            newUrl = loginServer + "/?redirect=" + url;
        }

        // 会话不存在不允许访问
        response.sendRedirect(newUrl);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
