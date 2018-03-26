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
@Table(name = "sys_company_customer", schema = "ecloud", catalog = "")
public class AgencyCustomer extends BizEntity{

    private UUID CustomerAgencyId;

    /**
     * 名称
     */
    private String name;
    /**
     *地址
     */
    private String address;
    /**
     *签约时间
     */
    private Date signDate;
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



    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "signDate")
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Basic
    @Column(name = "leader")
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "leaderMobile")
    public String getLeaderMobile() {
        return leaderMobile;
    }

    public void setLeaderMobile(String leaderMobile) {
        this.leaderMobile = leaderMobile;
    }

    @Basic
    @Column(name = "leaderEmail")
    public String getLeaderEmail() {
        return leaderEmail;
    }

    public void setLeaderEmail(String leaderEmail) {
        this.leaderEmail = leaderEmail;
    }


}
