package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.*;
import java.util.*;


/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业客户信息
 */
@Entity
@Table(name = "sys_ag_customer")
public class AgencyCustomer extends BizEntity{

    private UUID customerAgencyId;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     *地址
     */
    @Column(name = "address")
    private String address;
    /**
     *签约时间
     */
    @Column(name = "signDate")
    private Date signDate;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
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

    public UUID getCustomerAgencyId() {
        return customerAgencyId;
    }

    public void setCustomerAgencyId(UUID customerAgencyId) {
        this.customerAgencyId = customerAgencyId;
    }
}
