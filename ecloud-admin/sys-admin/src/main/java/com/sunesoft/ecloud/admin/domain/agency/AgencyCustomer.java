package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.adminclient.CustomerType;
import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;


/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业客户信息
 */
@Entity
@Table(name = "sys_ag_customer")
public class AgencyCustomer extends IEntity{

    @Column(name = "customerAgencyId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerAgencyId;

    @ManyToOne
    @JoinColumn(name = "agId")
    private Agency agency;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 客户类型
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    /**
     * QQ
     */
    @Column(name = "qq")
    private String qq;
    /**
     * 地区code
     */
    @Column(name = "addressCode")
    private String addressCode;
    /**
     * 省
     */
    @Column(name = "province")
    private String province;
    /**
     *市
     */
    @Column(name = "city")
    private String city;
    /**
     *区
     */
    @Column(name = "district")
    private String district;
    /**
     *街道
     */
    @Column(name = "street")
    private String street;
    /**
     *签约时间
     */
    @Column(name = "signDate")
    private LocalDateTime signDate;
    /**
     *客户负责人
     */
    @Column(name = "leader")
    private String leader;
    /**
     *客户负责人手机
     */
    @Column(name = "leaderMobile")
    private String leaderMobile;
    /**
     *客户负责人邮箱
     */
    @Column(name = "leaderEmail")
    private String leaderEmail;

    /**
     * 传真
     */
    @Column(name = "fax")
    private String fax;

    /**
     * 业务顾问Id
     */
    @Column(name = "consultantId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID consultantId;

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
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

    public UUID getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(UUID consultantId) {
        this.consultantId = consultantId;
    }

    public UUID getCustomerAgencyId() {
        return customerAgencyId;
    }

    public void setCustomerAgencyId(UUID customerAgencyId) {
        this.customerAgencyId = customerAgencyId;
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
