package com.sunesoft.ecloud.adminclient.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @Author: niww
 * @Date: 2018/3/26
 * 客户
 */
 public class AgencyCustomerDto {

     private UUID id;

    /**
     * 所属企业id
     */
    private UUID agId;
    /**
     * 名称
     */
    private String name;
    /**
     * 地区code
     */
    private String addressCode;
    /**
     * 省
     */
    private String province;
    /**
     *市
     */
    private String city;
    /**
     *区
     */
    private String district;
    /**
     *街道
     */
    private String street;
    /**
     *签约时间
     */
    private String signDate;
    /**
     *客户负责人
     */
    private String leader;
    /**
     *客户负责人手机
     */
    private String leaderMobile;
    /**
     *客户负责人邮箱
     */
    private String leaderEmail;

    /**
     * 业务顾问Id
     */
    private UUID consultantId;

    /**
     * 业务顾问名称
     */
    private String consultantName;

    /**
     * 按键数量
     */
    private Integer caseNumber;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public UUID getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(UUID consultantId) {
        this.consultantId = consultantId;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }


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

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderMobile() {
        return leaderMobile;
    }

    public void setLeaderMobile(String leaderMobile) {
        this.leaderMobile = leaderMobile;
    }

    public String getLeaderEmail() {
        return leaderEmail;
    }

    public void setLeaderEmail(String leaderEmail) {
        this.leaderEmail = leaderEmail;
    }

    public Integer getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Integer caseNumber) {
        this.caseNumber = caseNumber;
    }
}
