package com.sunesoft.ecloud.adminclient.dtos;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @Author: niww
 * @Date: 2018/3/26
 * 客户dto
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

    /**
     * 业务顾问Id
     */
    private UUID consultantId;

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

    /**
     * 业务顾问名称
     */
    private String consultantName;

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
}
