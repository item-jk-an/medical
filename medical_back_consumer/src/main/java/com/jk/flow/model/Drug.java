package com.jk.flow.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Drug implements Serializable {
    private static final long serialVersionUID = -5072210401188986885L;
    private Integer drugId;

    private String drugName;

    private Short drugBrand;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date drugAdddate;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date drugUpdate;

    private Short drugState;

    private Short drugType;

    private Short drugShen;

    private String drugInfo;

    private Integer drugHits;

    private Integer drugPrice;

    private Integer drugGrade;

    private Short drugShowlevel;

    private String drugCompany;

    private  String  drugAdddatemin;

    private  String  drugAdddatemax;

    private   String   ids;
    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private   String   showAdddate;
    SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private   String   showupdate;

    private  String brandName;


    private Integer drugPricemin;

    private Integer drugPricemax;

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Short getDrugBrand() {
        return drugBrand;
    }

    public void setDrugBrand(Short drugBrand) {
        this.drugBrand = drugBrand;
    }

    public Date getDrugAdddate() {
        return drugAdddate;
    }

    public void setDrugAdddate(Date drugAdddate) {
        this.drugAdddate = drugAdddate;
    }

    public Date getDrugUpdate() {
        return drugUpdate;
    }

    public void setDrugUpdate(Date drugUpdate) {
        this.drugUpdate = drugUpdate;
    }

    public Short getDrugState() {
        return drugState;
    }

    public void setDrugState(Short drugState) {
        this.drugState = drugState;
    }

    public Short getDrugType() {
        return drugType;
    }

    public void setDrugType(Short drugType) {
        this.drugType = drugType;
    }

    public Short getDrugShen() {
        return drugShen;
    }

    public void setDrugShen(Short drugShen) {
        this.drugShen = drugShen;
    }

    public String getDrugInfo() {
        return drugInfo;
    }

    public void setDrugInfo(String drugInfo) {
        this.drugInfo = drugInfo == null ? null : drugInfo.trim();
    }

    public Integer getDrugHits() {
        return drugHits;
    }

    public void setDrugHits(Integer drugHits) {
        this.drugHits = drugHits;
    }

    public Integer getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Integer drugPrice) {
        this.drugPrice = drugPrice;
    }

    public Integer getDrugGrade() {
        return drugGrade;
    }

    public void setDrugGrade(Integer drugGrade) {
        this.drugGrade = drugGrade;
    }

    public Short getDrugShowlevel() {
        return drugShowlevel;
    }

    public void setDrugShowlevel(Short drugShowlevel) {
        this.drugShowlevel = drugShowlevel;
    }

    public String getDrugCompany() {
        return drugCompany;
    }

    public void setDrugCompany(String drugCompany) {
        this.drugCompany = drugCompany == null ? null : drugCompany.trim();
    }

    public String getDrugAdddatemin() {
        return drugAdddatemin;
    }

    public void setDrugAdddatemin(String drugAdddatemin) {
        this.drugAdddatemin = drugAdddatemin;
    }

    public String getDrugAdddatemax() {
        return drugAdddatemax;
    }

    public void setDrugAdddatemax(String drugAdddatemax) {
        this.drugAdddatemax = drugAdddatemax;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getShowAdddate() {
        return drugAdddate!=null?sim.format(drugAdddate):"";
    }

    public void setShowAdddate(String showAdddate) {
        this.showAdddate = showAdddate;
    }

    public String getShowupdate() {
        return drugUpdate!=null?sim.format(drugUpdate):"";
    }

    public void setShowupdate(String showupdate) {
        this.showupdate = showupdate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getDrugPricemax() {
        return drugPricemax;
    }

    public void setDrugPricemax(Integer drugPricemax) {
        this.drugPricemax = drugPricemax;
    }

}