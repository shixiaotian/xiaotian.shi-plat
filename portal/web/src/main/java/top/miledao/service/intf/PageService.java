package top.miledao.service.intf;

/**
 * Created by xiaotian.shi on 2017/6/1.
 */
public interface PageService {

    /**
     *
     * 获取静态资源地址
     *
     * @return
     */
    String getStaticServerhosts();

    /**
     *
     * 获取页面资源
     * 组装静态资源地址和版本号
     *
     * @param url 传入相对地址
     * @return
     */
    String getResource(String url);
}
