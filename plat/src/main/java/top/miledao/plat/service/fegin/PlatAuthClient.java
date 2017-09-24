package top.miledao.plat.service.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiaotian.shi on 2017/7/28.
 */
// 指定远程服务器名称
@FeignClient("xiaotian-login")
public interface PlatAuthClient {

    /**
     *
     * 检查是否有访问权限
     *
     * @param loginId 登陆账号
     * @param target 访问目标
     * @return
     */
    @RequestMapping(value = "/auth", method={RequestMethod.POST})
    boolean check(@RequestParam("loginId") String loginId, @RequestParam("target") String target);

    /**
     *
     * 获取权限服务器地址
     *
     * @return
     */
    @RequestMapping(value = {"/auth/host"}, method={RequestMethod.POST})
    public String getAuthHost();

}

