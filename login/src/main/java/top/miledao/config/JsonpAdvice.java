package top.miledao.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by xiaotian.shi on 2017/7/23.
 */

@ControllerAdvice(basePackages = "top.miledao.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback","jsonp");
    }
}