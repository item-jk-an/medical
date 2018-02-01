package com.jk.power.pojo;

import java.io.Serializable;
import java.util.List;

public class Power implements Serializable{
    private static final long serialVersionUID = -3633088229590017041L;
    private Integer id;

    private Integer pid;

    private String text;

    private String url;

    private List<Power> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public List<Power> getNodes() {
        return nodes;
    }

    public void setNodes(List<Power> nodes) {
        this.nodes = nodes;
    }
}