package com.jk.supplier.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Supplier implements Serializable{
    private static final long serialVersionUID = -4955565150517700877L;
    private Integer supId;

    private String supName;

    private String supPhone;

    private String supAddress;

    private Short supCreditlevel;

    private String supInfo;

    private Integer supKits;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date supAdddate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date supUpdate;

    private String supLinkman;

    private Short supType;

    private String supFrame;

    private Short supCheckstate;

    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
    private   String   showAdddate;
    SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd");
    private   String   showupdate;

    private  Short  supBrand;

    private  String   brandName;

    private String supAdddatemin;

    private String supAdddatemax;

    public String getSupAdddatemin() {
        return supAdddatemin;
    }

    public void setSupAdddatemin(String supAdddatemin) {
        this.supAdddatemin = supAdddatemin;
    }

    public String getSupAdddatemax() {
        return supAdddatemax;
    }

    public void setSupAdddatemax(String supAdddatemax) {
        this.supAdddatemax = supAdddatemax;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName == null ? null : supName.trim();
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone == null ? null : supPhone.trim();
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress == null ? null : supAddress.trim();
    }

    public Short getSupCreditlevel() {
        return supCreditlevel;
    }

    public void setSupCreditlevel(Short supCreditlevel) {
        this.supCreditlevel = supCreditlevel;
    }

    public String getSupInfo() {
        return supInfo;
    }

    public void setSupInfo(String supInfo) {
        this.supInfo = supInfo == null ? null : supInfo.trim();
    }

    public Integer getSupKits() {
        return supKits;
    }

    public void setSupKits(Integer supKits) {
        this.supKits = supKits;
    }

    public Date getSupAdddate() {
        return supAdddate;
    }

    public void setSupAdddate(Date supAdddate) {
        this.supAdddate = supAdddate;
    }

    public Date getSupUpdate() {
        return supUpdate;
    }

    public void setSupUpdate(Date supUpdate) {
        this.supUpdate = supUpdate;
    }

    public String getSupLinkman() {
        return supLinkman;
    }

    public void setSupLinkman(String supLinkman) {
        this.supLinkman = supLinkman == null ? null : supLinkman.trim();
    }

    public Short getSupType() {
        return supType;
    }

    public void setSupType(Short supType) {
        this.supType = supType;
    }

    public String getSupFrame() {
        return supFrame;
    }

    public void setSupFrame(String supFrame) {
        this.supFrame = supFrame == null ? null : supFrame.trim();
    }

    public Short getSupCheckstate() {
        return supCheckstate;
    }

    public void setSupCheckstate(Short supCheckstate) {
        this.supCheckstate = supCheckstate;
    }

    public String getShowAdddate() {
        return supAdddate!=null?sim.format(supAdddate):"";
    }

    public void setShowAdddate(String showAdddate) {
        this.showAdddate = showAdddate;
    }

    public String getShowupdate() {
        return supUpdate!=null?sim.format(supUpdate):"";
    }

    public void setShowupdate(String showupdate) {
        this.showupdate = showupdate;
    }

    public Short getSupBrand() {
        return supBrand;
    }

    public void setSupBrand(Short supBrand) {
        this.supBrand = supBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}