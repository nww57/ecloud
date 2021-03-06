package com.sunesoft.ecloud.adminclient.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunesoft.ecloud.adminclient.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signDate;
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

    /**
     * 客户类型
     */
    private CustomerType type;

    /**
     * QQ
     */
    private String qq;

    /**
     * 传真
     */
    private String fax;

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

    public LocalDateTime getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDateTime signDate) {
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

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
