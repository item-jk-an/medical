package com.jk.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Admin implements Serializable {
    private static final long serialVersionUID = -633649213471444421L;
    private Integer adminId;

    private String adminMane;

    private String adminPwd;

    private Date adminCreationTime;

    private List<Admin> list;

    private Short adminLv;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminMane() {
        return adminMane;
    }

    public void setAdminMane(String adminMane) {
        this.adminMane = adminMane == null ? null : adminMane.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public Date getAdminCreationTime() {
        return adminCreationTime;
    }

    public void setAdminCreationTime(Date adminCreationTime) {
        this.adminCreationTime = adminCreationTime;
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    public Short getAdminLv() {
        return adminLv;
    }

    public void setAdminLv(Short adminLv) {
        this.adminLv = adminLv;
    }
}