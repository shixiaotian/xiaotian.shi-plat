package top.miledao.plat.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import top.miledao.plat.service.fegin.PlatAuthClient;

/**
 *
 * 异常处理增强器
 *
 * Created by xiaotian.shi on 2017/7/30.
 */
@ControllerAdvice
public class PlatExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private String loginServer;

    @Autowired
    private PlatAuthClient authClient;

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception ex) {

        String errorPage = "redirect:" + this.getLoginServer() + "/error500";
        logger.error("ERROR", ex);

        return errorPage;
    }

    private String getLoginServer() {

        if(StringUtils.isEmpty(loginServer)) {
            loginServer = authClient.getAuthHost();
        }

        return loginServer;

    }
}
