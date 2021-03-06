package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.adminclient.ApplicantType;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 专利申请人
 */
@Entity
@Table(name = "pat_applicant", schema = "springcloud", catalog = "")
public class PatApplicant extends IEntity {

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     * 客户申请人id
     */
    @Column(name = "customerApplicantId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerApplicantId;

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
     * 邮编
     */
    @Column(name = "zipCode")
    private String zipCode;


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

    /**
     * 用于区分第一、第二。。。申请人
     */
    @Column(name = "sort")
    private int sort;

    public PatApplicant() {
    }

    public PatApplicant(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public UUID getCustomerApplicantId() {
        return customerApplicantId;
    }

    public void setCustomerApplicantId(UUID customerApplicantId) {
        this.customerApplicantId = customerApplicantId;
    }

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
