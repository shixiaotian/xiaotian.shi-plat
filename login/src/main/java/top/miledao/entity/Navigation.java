package top.miledao.entity;

import java.io.Serializable;

/**
 * Created by xiaotian.shi on 2017/7/29.
 */
public class Navigation implements Serializable{

    // 位置索引
    private Integer index;

    // 中文名称
    private String name;

    // 目标地址
    private String url;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
