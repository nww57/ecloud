package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class Contactor {

    @XStreamAlias("姓名")
    private String name;

    @XStreamAlias("电话")
    private String phone;

    @XStreamAlias("电子邮箱")
    private String email;

    @XStreamAlias("邮政编码")
    private String zipCode;

    @XStreamAlias("省自治区直辖市名称")
    private String provinceCode;

    @XStreamAlias("市县名称")
    private String cityCode;

    @XStreamAlias("城区乡街道门牌号")
    private String areaDetail;

    public Contactor() {
        this.name = "";
        this.phone = "";
        this.email = "";
        this.zipCode = "";
        this.provinceCode = "";
        this.cityCode = "";
        this.areaDetail = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
}
