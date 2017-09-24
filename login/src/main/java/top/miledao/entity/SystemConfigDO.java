package top.miledao.entity;

import top.miledao.common.CommonDO;

/**
 *
 * 系统配置do
 *
 * Created by xiaotian.shi on 2017/6/8.
 */
public class SystemConfigDO extends CommonDO{

    // 配置
    private String config;

    // 配置名称
    private String configName;

    // 配置的值
    private String value;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }
}
