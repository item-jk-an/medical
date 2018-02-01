package com.jk.user.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable{
    private static final long serialVersionUID = -6147656549326938007L;

	private Integer userId;

    private String userAccount;

    private String userPhone;

    private String userNiki;

    private String userPass;

    private String userHeadId;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date loginTime;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date registerTime;

    private Short userState;

    private Short userType;

    private Short userLevel;

    private Integer userScore;

    private Integer infoId;

    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private String showRegDate;

    private String showLoginDate;

    public String getShowRegDate() {
        return this.registerTime != null?sim.format(this.registerTime):"";
    }

    public void setShowRegDate(String showRegDate) {
        this.showRegDate = showRegDate;
    }

    public String getShowLoginDate() {
        return this.loginTime != null?sim.format(this.loginTime):"";
    }

    public void setShowLoginDate(String showLoginDate) {
        this.showLoginDate = showLoginDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserNiki() {
        return userNiki;
    }

    public void setUserNiki(String userNiki) {
        this.userNiki = userNiki == null ? null : userNiki.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserHeadId() {
        return userHeadId;
    }

    public void setUserHeadId(String userHeadId) {
        this.userHeadId = userHeadId == null ? null : userHeadId.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Short getUserState() {
        return userState;
    }

    public void setUserState(Short userState) {
        this.userState = userState;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Short userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }
}