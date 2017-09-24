package top.miledao.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import top.miledao.vo.JsonResponse;

/**
 * Created by xiaotian.shi on 2017/7/15.
 */
@Controller
@SessionAttributes({"loginUser"})
public class BaseController{

    @ResponseBody
    public JsonResponse printSuccess() {

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(200);
        jsonResponse.setStatus(true);
        jsonResponse.setMsg("成功");

        return jsonResponse;
    }

    @ResponseBody
    public JsonResponse printSuccess(String msg) {

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(200);
        jsonResponse.setStatus(true);
        jsonResponse.setMsg(msg);

        return jsonResponse;
    }

    @ResponseBody
    public JsonResponse printSuccess(String msg, Object data) {

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(200);
        jsonResponse.setStatus(true);
        jsonResponse.setMsg(msg);
        jsonResponse.setData(data);

        return jsonResponse;
    }

    @ResponseBody
    public JsonResponse printFail(String msg) {

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(201);
        jsonResponse.setStatus(true);
        jsonResponse.setMsg(msg);

        return jsonResponse;
    }

    @ResponseBody
    public JsonResponse print(String msg, int code, Object data) {

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(code);
        jsonResponse.setStatus(true);
        jsonResponse.setMsg(msg);
        jsonResponse.setData(data);

        return jsonResponse;
    }

    @ResponseBody
    public JsonResponse printFail(String msg, int code) {

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(code);
        jsonResponse.setStatus(true);
        jsonResponse.setMsg(msg);

        return jsonResponse;
    }


}
