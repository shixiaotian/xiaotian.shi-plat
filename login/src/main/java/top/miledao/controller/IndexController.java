package top.miledao.controller;

/**
 * Created by xiaotian.shi on 2017/4/6.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


    @RequestMapping(value = {"/","/index"})
    String home() {

        return "login";

    }


}
