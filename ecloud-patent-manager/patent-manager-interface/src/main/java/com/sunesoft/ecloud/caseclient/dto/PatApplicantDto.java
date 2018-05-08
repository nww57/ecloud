package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.adminclient.ApplicantType;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 */
public class PatApplicantDto {


    private UUID id;

    private UUID patentId;

    /**
     * 姓名
     */
    private String name;

    /**
     *国家code
     */
    private String countryCode;

    /**
     *国家 名称
     */
    private String countryName;

    /**
     *申请人类型
     */
    private ApplicantType type;


    /**
     *身份证号码/统一会信用代码
     */
    private String idCode;


    /**
     *是否通过国知局费减备案
     */
    private Boolean record;


    /**
     * 省code
     */
    private String provinceCode;

    /**
     * 省名
     */
    private String provinceName;

    /**
     * 市code
     */
    private String cityCode;

    /**
     * 市名
     */
    private String cityName;

    /**
     * 区code
     */
    private String districtCode;

    /**
     * 区名
     */
    private String districtName;

    /**
     * 详细地址
     */
    private String areaDetail;

    /**
     * 邮编
     */
    private String zipCode;


    /**
     * 经常居所地
     */
    private String liveAddress;

    /**
     * 用户代码
     */
    private String userCode;

    /**
     * 用于区分第一、第二代申请人
     * 1 第一申请人
     * 2 第二申请人
     * 3 第三申请人
     */
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ApplicantType getType() {
        return type;
    }

    public void setType(ApplicantType type) {
        this.type = type;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Boolean getRecord() {
        return record;
    }

    public void setRecord(Boolean record) {
        this.record = record;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAreaDetail() {
        return areaDetail;
    }

    public void setAreaDetail(String areaDetail) {
        this.areaDetail = areaDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
