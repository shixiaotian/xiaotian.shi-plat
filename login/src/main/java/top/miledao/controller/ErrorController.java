package top.miledao.controller;

/**
 * Created by xiaotian.shi on 2017/4/6.
 */

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@Controller
public class ErrorController {


    @RequestMapping(value = {"/error401",})
//    @ResponseStatus(reason="unAuthorized",value= HttpStatus.UNAUTHORIZED)
    String unAuthorized(Map<String,Object> map) {

        map.put("errorCode", "401");
        map.put("errorMsg", "对不起，没有权限！");
        return "/error";

    }

    @RequestMapping(value = {"/error404",})
//    @ResponseStatus(reason="notFound",value= HttpStatus.NOT_FOUND)
    String notFound(Map<String,Object> map) {

        map.put("errorCode", "404");
        map.put("errorMsg", "资源不存在。");
        return "/error";

    }
    @RequestMapping(value = {"/error500",})
//    @ResponseStatus(reason="internalServerError",value= HttpStatus.INTERNAL_SERVER_ERROR)
    String internalServerError(Map<String,Object> map) {

        map.put("errorCode", "500");
        map.put("errorMsg", "发生错误，请联系管理员。");
        return "/error";

    }

}
