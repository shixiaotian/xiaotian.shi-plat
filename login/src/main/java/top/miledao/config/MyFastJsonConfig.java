package top.miledao.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 *
 * fastjson配置，使用后jsonp失效
 *
 * Created by xiaotian.shi on 2017/7/23.
 */
@Configuration
public class MyFastJsonConfig {

    /*注入Bean : HttpMessageConverters，以支持fastjson*/
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastConvert.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters((HttpMessageConverter<?>) fastConvert);
//    }
}
