package com.jk.flow.model;

import java.io.Serializable;
import java.util.Date;

public class Info1 implements Serializable{
    private static final long serialVersionUID = 7026680542877812150L;
    private Integer infoId;

    private String userName;

    private Short userSex;

    private Short userAge;

    private Date userBirth;

    private String userAddress;

    private String userEmail;

    private String userIntro;

    private String eductionCard;

    private String bodyCard;

    private String statusCard;

    private String doctorCard;

    private String medicalResult;

    private String promiseBook;

    private Short checkState;

    private Short info1First;

    private Short info1Second;

    private Short info1Third;

    private byte[] medicalGo;

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

    public Short getUserSex() {
        return userSex;
    }

    public void setUserSex(Short userSex) {
        this.userSex = userSex;
    }

    public Short getUserAge() {
        return userAge;
    }

    public void setUserAge(Short userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
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

    public String getEductionCard() {
        return eductionCard;
    }

    public void setEductionCard(String eductionCard) {
        this.eductionCard = eductionCard == null ? null : eductionCard.trim();
    }

    public String getBodyCard() {
        return bodyCard;
    }

    public void setBodyCard(String bodyCard) {
        this.bodyCard = bodyCard == null ? null : bodyCard.trim();
    }

    public String getStatusCard() {
        return statusCard;
    }

    public void setStatusCard(String statusCard) {
        this.statusCard = statusCard == null ? null : statusCard.trim();
    }

    public String getDoctorCard() {
        return doctorCard;
    }

    public void setDoctorCard(String doctorCard) {
        this.doctorCard = doctorCard == null ? null : doctorCard.trim();
    }

    public String getMedicalResult() {
        return medicalResult;
    }

    public void setMedicalResult(String medicalResult) {
        this.medicalResult = medicalResult == null ? null : medicalResult.trim();
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

    public Short getInfo1First() {
        return info1First;
    }

    public void setInfo1First(Short info1First) {
        this.info1First = info1First;
    }

    public Short getInfo1Second() {
        return info1Second;
    }

    public void setInfo1Second(Short info1Second) {
        this.info1Second = info1Second;
    }

    public Short getInfo1Third() {
        return info1Third;
    }

    public void setInfo1Third(Short info1Third) {
        this.info1Third = info1Third;
    }

    public byte[] getMedicalGo() {
        return medicalGo;
    }

    public void setMedicalGo(byte[] medicalGo) {
        this.medicalGo = medicalGo;
    }
}