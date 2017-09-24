package top.miledao.service.intf;

import java.util.List;
import java.util.Map;

/**
 *
 * 权限数据服务类
 *
 * Created by xiaotian.shi on 2017/7/30.
 */
public interface AuthService {

    /**
     *
     * 获取权限数据
     *
     * @return
     */
    public Map<String, List<String>> getAuthData();
}
