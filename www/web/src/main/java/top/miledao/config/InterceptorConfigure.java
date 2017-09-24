package top.miledao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.miledao.plat.common.interceptor.PlatAuthInterceptor;
import top.miledao.plat.common.interceptor.PlatSessionInterceptor;
import top.miledao.common.interceptor.GlobalInterceptor;
import top.miledao.common.interceptor.GlobalToolsInterceptor;

/**
 * Created by xiaotian.shi on 2017/6/1.
 */
@Configuration
public class InterceptorConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 会话拦截器
        registry.addInterceptor(this.sessionInterceptor()).addPathPatterns("/**");

        // 权限过滤器
        registry.addInterceptor(this.authInterceptor()).addPathPatterns("/**");

        // 全局过滤器
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");

        // 自定义全局工具过滤器
        registry.addInterceptor(new GlobalToolsInterceptor()).addPathPatterns("/**");
    }

    // 解决拦截器不能注入实例的问题
    @Bean
    @Scope("singleton")
    PlatSessionInterceptor sessionInterceptor() {
        return new PlatSessionInterceptor();
    }

    // 解决拦截器不能注入实例的问题
    @Bean
    @Scope("singleton")
    PlatAuthInterceptor authInterceptor() {
        return new PlatAuthInterceptor();
    }
}
