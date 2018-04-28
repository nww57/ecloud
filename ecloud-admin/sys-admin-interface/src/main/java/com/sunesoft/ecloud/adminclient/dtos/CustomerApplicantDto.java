package com.sunesoft.ecloud.adminclient.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunesoft.ecloud.adminclient.ApplicantType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户申请人操作dto
 */
public class CustomerApplicantDto {

    private UUID id;

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
     *身份证/机构代码
     */
    private String code;

    /**
     *是否通过国知局费减备案
     */
    private Boolean record;


    /**
     *备案有效期
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern  = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordValidDate;

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
     * 所属客户
     */
    private UUID customerId;

    /**
     * 经常居所地
     */
    private String liveAddress;

    /**
     * 用户代码
     */
    private String userCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getAreaDetail() {
        return areaDetail;
    }

    public void setAreaDetail(String areaDetail) {
        this.areaDetail = areaDetail;
    }

    public ApplicantType getType() {
        return type;
    }

    public void setType(ApplicantType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getRecord() {
        return record;
    }

    public void setRecord(Boolean record) {
        this.record = record;
    }

    public LocalDateTime getRecordValidDate() {
        return recordValidDate;
    }

    public void setRecordValidDate(LocalDateTime recordValidDate) {
        this.recordValidDate = recordValidDate;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
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
