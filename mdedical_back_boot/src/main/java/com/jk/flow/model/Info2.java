package com.jk.flow.model;

import java.io.Serializable;

public class Info2 implements Serializable{
    private static final long serialVersionUID = 2416818494961892095L;
    private Integer infoId;

    private String userName;

    private String userAddress;

    private String userLogo;

    private String userEmail;

    private String userIntro;

    private String studyDirection;

    private String netUrl;

    private String userStruture;

    private Short userType;

    private Short userLevel;

    private String businessCard;

    private String statusCard;

    private String promiseBook;

    private Short checkState;

    private Short info2First;

    private Short info2Second;

    private Short info2Third;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo == null ? null : userLogo.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    public String getStudyDirection() {
        return studyDirection;
    }

    public void setStudyDirection(String studyDirection) {
        this.studyDirection = studyDirection == null ? null : studyDirection.trim();
    }

    public String getNetUrl() {
        return netUrl;
    }

    public void setNetUrl(String netUrl) {
        this.netUrl = netUrl == null ? null : netUrl.trim();
    }

    public String getUserStruture() {
        return userStruture;
    }

    public void setUserStruture(String userStruture) {
        this.userStruture = userStruture == null ? null : userStruture.trim();
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

    public String getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard == null ? null : businessCard.trim();
    }

    public String getStatusCard() {
        return statusCard;
    }

    public void setStatusCard(String statusCard) {
        this.statusCard = statusCard == null ? null : statusCard.trim();
    }

    public String getPromiseBook() {
        return promiseBook;
    }

    public void setPromiseBook(String promiseBook) {
        this.promiseBook = promiseBook == null ? null : promiseBook.trim();
    }

    public Short getCheckState() {
        return checkState;
    }

    public void setCheckState(Short checkState) {
        this.checkState = checkState;
    }

    public Short getInfo2First() {
        return info2First;
    }

    public void setInfo2First(Short info2First) {
        this.info2First = info2First;
    }

    public Short getInfo2Second() {
        return info2Second;
    }

    public void setInfo2Second(Short info2Second) {
        this.info2Second = info2Second;
    }

    public Short getInfo2Third() {
        return info2Third;
    }

    public void setInfo2Third(Short info2Third) {
        this.info2Third = info2Third;
    }
}