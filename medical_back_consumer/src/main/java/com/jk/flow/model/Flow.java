package com.jk.flow.model;

import java.io.Serializable;

public class Flow implements Serializable{
    private static final long serialVersionUID = -4289319823714494149L;
    private Integer flowId;

    private String flowName;

    private String roleIds;

    private String userIds;

    private Integer roleId1;

    private Integer roleId2;

    private Integer roleId3;

    private Integer roleId4;

    private Integer roleId5;

    private Integer userId1;

    private Integer userId2;

    private Integer userId3;

    private Integer userId4;

    private Integer userId5;

    private Short flowType;

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

    public Integer getRoleId1() {
        return roleId1;
    }

    public void setRoleId1(Integer roleId1) {
        this.roleId1 = roleId1;
    }

    public Integer getRoleId2() {
        return roleId2;
    }

    public void setRoleId2(Integer roleId2) {
        this.roleId2 = roleId2;
    }

    public Integer getRoleId3() {
        return roleId3;
    }

    public void setRoleId3(Integer roleId3) {
        this.roleId3 = roleId3;
    }

    public Integer getRoleId4() {
        return roleId4;
    }

    public void setRoleId4(Integer roleId4) {
        this.roleId4 = roleId4;
    }

    public Integer getRoleId5() {
        return roleId5;
    }

    public void setRoleId5(Integer roleId5) {
        this.roleId5 = roleId5;
    }

    public Integer getUserId1() {
        return userId1;
    }

    public void setUserId1(Integer userId1) {
        this.userId1 = userId1;
    }

    public Integer getUserId2() {
        return userId2;
    }

    public void setUserId2(Integer userId2) {
        this.userId2 = userId2;
    }

    public Integer getUserId3() {
        return userId3;
    }

    public void setUserId3(Integer userId3) {
        this.userId3 = userId3;
    }

    public Integer getUserId4() {
        return userId4;
    }

    public void setUserId4(Integer userId4) {
        this.userId4 = userId4;
    }

    public Integer getUserId5() {
        return userId5;
    }

    public void setUserId5(Integer userId5) {
        this.userId5 = userId5;
    }

    public Short getFlowType() {
        return flowType;
    }

    public void setFlowType(Short flowType) {
        this.flowType = flowType;
    }
}