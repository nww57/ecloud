package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.adminclient.ApplicantType;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 客户申请人维护
 */
@Entity
@Table(name = "customer_applicant")
public class CustomerApplicant extends IEntity{

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     *国家code
     */
    @Column(name = "countryCode")
    private String countryCode;

    /**
     *国家 名称
     */
    @Column(name = "countryName")
    private String countryName;

    /**
     *申请人类型
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ApplicantType type;


    /**
     *身份证号码/统一会信用代码
     */
    @Column(name = "idCode")
    private String idCode;


    /**
     *是否通过国知局费减备案
     */
    @Column(name = "record")
    private Boolean record;


    /**
     * 省code
     */
    @Column(name = "provinceCode")
    private String provinceCode;

    /**
     * 省名
     */
    @Column(name = "provinceName")
    private String provinceName;

    /**
     * 市code
     */
    @Column(name = "cityCode")
    private String cityCode;

    /**
     * 市名
     */
    @Column(name = "cityName")
    private String cityName;

    /**
     * 区code
     */
    @Column(name = "districtCode")
    private String districtCode;

    /**
     * 区名
     */
    @Column(name = "districtName")
    private String districtName;

    /**
     * 详细地址
     */
    @Column(name = "areaDetail")
    private String areaDetail;


    /**
     * 所属客户
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;

    /**
     * 经常居所地
     */
    @Column(name = "liveAddress")
    private String liveAddress;

    /**
     * 用户代码
     */
    @Column(name = "userCode")
    private String userCode;

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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getAreaDetail() {
        return areaDetail;
    }

    public void setAreaDetail(String areaDetail) {
        this.areaDetail = areaDetail;
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
