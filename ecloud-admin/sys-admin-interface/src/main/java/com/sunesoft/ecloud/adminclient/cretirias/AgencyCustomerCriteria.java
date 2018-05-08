package com.sunesoft.ecloud.adminclient.cretirias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 */
public class AgencyCustomerCriteria extends TCretiria{

    /**
     * 企业id
     */
    private UUID agId;
    /**
     * 关键字
     */
    private String keywords;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 负责人手机
     */
    private String leaderMobile;

    /**
     * 负责人邮箱
     */
    private String leaderEmail;

    /**
     * 业务顾问姓名
     */
    private String consultantName;

    /**
     * 签约起始时间
     */
    private String signDateStart;

    /**
     * 签约截止时间
     */
    private String signDateEnd;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getSignDateStart() {
        return signDateStart;
    }

    public void setSignDateStart(String signDateStart) {
        this.signDateStart = signDateStart;
    }

    public String getSignDateEnd() {
        return signDateEnd;
    }

    public void setSignDateEnd(String signDateEnd) {
        this.signDateEnd = signDateEnd;
    }
}
