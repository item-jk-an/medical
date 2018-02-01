package com.jk.flow.model;

import java.io.Serializable;
import java.util.Date;

public class UserLogin implements Serializable{
    private static final long serialVersionUID = -9109179843444591230L;
    private Integer userId;

    private String userAccount;

    private String userPhone;

    private String userNiki;

    private String userPass;

    private String userHeadId;

    private Date loginTime;

    private Date registerTime;

    private Short userState;

    private Short userType;

    private Short userLevel;

    private Integer userScore;

    private Integer infoId;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", userAccount=" + userAccount + ", userPhone=" + userPhone
				+ ", userNiki=" + userNiki + ", userPass=" + userPass + ", userHeadId=" + userHeadId + ", loginTime="
				+ loginTime + ", registerTime=" + registerTime + ", userState=" + userState + ", userType=" + userType
				+ ", userLevel=" + userLevel + ", userScore=" + userScore + ", infoId=" + infoId + "]";
	}
}