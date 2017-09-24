package top.miledao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.miledao.common.interceptor.GlobalInterceptor;
import top.miledao.common.interceptor.GlobalToolsInterceptor;

/**
 * Created by xiaotian.shi on 2017/6/1.
 */
@Configuration
public class InterceptorConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {



        // 全局过滤器
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");

        // 自定义全局工具过滤器
        registry.addInterceptor(new GlobalToolsInterceptor()).addPathPatterns("/**");

    }

}
