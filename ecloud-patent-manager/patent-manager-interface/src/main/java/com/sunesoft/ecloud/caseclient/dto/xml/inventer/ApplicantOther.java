package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamAlias("其他申请人")
public class ApplicantOther {
    @XStreamAlias("姓名或名称")
    private String name;

    @XStreamAlias("用户代码")
    private String userCode;

    @XStreamAlias("申请人类型")
    private String applicantType;

    @XStreamAlias("个人身份证号或组织机构代码")
    private String idCode;

    @XStreamAlias("国籍或总部所在地")
    private String countryCode;

    @XStreamAlias("经营所在地或营业所在地")
    private String liveAddressCode;

    @XStreamAlias("省自治区直辖市名称")
    private String provinceCode;

    @XStreamAlias("市县名称")
    private String cityCode;

    @XStreamAlias("城区乡街道门牌号")
    private String areaDetail;

    @XStreamAlias("邮政编码")
    private String zipCode;

    @XStreamAlias("电话")
    private String phone;

    @XStreamAlias("英文名称")
    private String nameEn;

    @XStreamAlias("英文地址")
    private String addressEn;

    @XStreamAlias("顺序")
    @XStreamAsAttribute
    private int sort;

    public ApplicantOther() {
        this.name = "";
        this.userCode = "";
        this.idCode = "";
        this.countryCode = "";
        this.applicantType = "";
        this.liveAddressCode = "";
        this.cityCode = "";
        this.areaDetail = "";
        this.zipCode = "";
        this.phone = "";
        this.nameEn = "";
        this.addressEn = "";
    }

    public ApplicantOther(int sort) {
        this.sort = sort;
        this.name = "";
        this.userCode = "";
        this.idCode = "";
        this.countryCode = "";
        this.liveAddressCode = "";
        this.cityCode = "";
        this.areaDetail = "";
        this.zipCode = "";
        this.applicantType = "";
        this.phone = "";
        this.nameEn = "";
        this.addressEn = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLiveAddressCode() {
        return liveAddressCode;
    }

    public void setLiveAddressCode(String liveAddressCode) {
        this.liveAddressCode = liveAddressCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }
}
