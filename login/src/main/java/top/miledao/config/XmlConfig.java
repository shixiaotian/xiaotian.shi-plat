package top.miledao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xiaotian.shi on 2017/7/15.
 */
@Configuration
@ImportResource(locations={"classpath:redis-bean.xml"})
public class XmlConfig {
}
