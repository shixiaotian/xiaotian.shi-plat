package top.miledao.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.miledao.common.BaseController;
import top.miledao.vo.JsonResponse;
import top.miledao.plat.vo.LoginUser;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 *
 * 验证码控制类
 *
 * Created by xiaotian.shi on 2017/7/22.
 */
@Controller
//@SessionAttributes({"loginUser"})
public class CaptchaController extends BaseController{

    @Autowired
    private DefaultKaptcha captchaProducer;

    @RequestMapping(value = "/login-captcha-image")
    public ModelAndView getKaptchaImage(
            LoginUser loginUser,
            HttpSession session, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();
        System.out.println("capText: " + capText);

        try {

            loginUser.setLoginToken(capText);
            session.setAttribute("loginUser", loginUser);

        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    @RequestMapping(value = {"/validateCaptchaCode"}, method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResponse getKaptchaImage(
                LoginUser loginUser,
            @RequestParam(value="captchaCode", required=false) String captchaCode
        ) throws Exception {

        String capTxt = loginUser.getLoginToken();

            if(captchaCode.equals(capTxt)) {
                return this.printSuccess();
            } else {
                return this.printFail("验证码不正确");
            }

    }

}
