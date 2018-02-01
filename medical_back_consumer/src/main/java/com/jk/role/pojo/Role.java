package com.jk.role.pojo;

import java.io.Serializable;

public class Role implements Serializable{
    private static final long serialVersionUID = -4743874354815932456L;
    private Integer roleId;

    private String roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}