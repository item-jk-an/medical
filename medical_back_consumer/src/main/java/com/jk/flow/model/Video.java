package com.jk.flow.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable{
    private static final long serialVersionUID = 1151735356374601612L;
    private Integer videoId;

    private String videoImg;

    private String videoName;

    private String videoUuid;

    private Short videoScore;

    private Short videoType;

    private String videoIntro;

    private Short videoStatue;

    private Date uploadTime;

    private Integer clickNum;

    private Short checkStatus;

    private Float videoPrice;

    private Short videoSource;

    private Short videoFirst;

    private Short videoSecond;

    private Short videoThird;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg == null ? null : videoImg.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoUuid() {
        return videoUuid;
    }

    public void setVideoUuid(String videoUuid) {
        this.videoUuid = videoUuid == null ? null : videoUuid.trim();
    }

    public Short getVideoScore() {
        return videoScore;
    }

    public void setVideoScore(Short videoScore) {
        this.videoScore = videoScore;
    }

    public Short getVideoType() {
        return videoType;
    }

    public void setVideoType(Short videoType) {
        this.videoType = videoType;
    }

    public String getVideoIntro() {
        return videoIntro;
    }

    public void setVideoIntro(String videoIntro) {
        this.videoIntro = videoIntro == null ? null : videoIntro.trim();
    }

    public Short getVideoStatue() {
        return videoStatue;
    }

    public void setVideoStatue(Short videoStatue) {
        this.videoStatue = videoStatue;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Float getVideoPrice() {
        return videoPrice;
    }

    public void setVideoPrice(Float videoPrice) {
        this.videoPrice = videoPrice;
    }

    public Short getVideoSource() {
        return videoSource;
    }

    public void setVideoSource(Short videoSource) {
        this.videoSource = videoSource;
    }

    public Short getVideoFirst() {
        return videoFirst;
    }

    public void setVideoFirst(Short videoFirst) {
        this.videoFirst = videoFirst;
    }

    public Short getVideoSecond() {
        return videoSecond;
    }

    public void setVideoSecond(Short videoSecond) {
        this.videoSecond = videoSecond;
    }

    public Short getVideoThird() {
        return videoThird;
    }

    public void setVideoThird(Short videoThird) {
        this.videoThird = videoThird;
    }
}