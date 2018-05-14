package com.sunesoft.ecloud.caseclient.dto.notice;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 费用减缓审批通知书
 */
@XStreamAlias("cn_notice_info")
public class FeeReduceApprovalNoticeDto extends NoticeXMLBasicDto{

    /**
     *费减请求日期
     */
    private String cost_slow_req_date;

    /**
     *费减记录
     */
    private String cost_slow_mes;

    /**
     *缴费截止日期
     */
    private String pay_deadline_date;

    /**
     * 所有费用信息
     */
    private FeeInfoAllDto fee_info_all;

    /**
     *年费费减比例
     */
    private String cost_slow_rate_annul;

    /**
     *复审费减比例
     */
    private String cost_slow_rate_review;

    public String getCost_slow_req_date() {
        return cost_slow_req_date;
    }

    public void setCost_slow_req_date(String cost_slow_req_date) {
        this.cost_slow_req_date = cost_slow_req_date;
    }

    public String getCost_slow_mes() {
        return cost_slow_mes;
    }

    public void setCost_slow_mes(String cost_slow_mes) {
        this.cost_slow_mes = cost_slow_mes;
    }

    public String getPay_deadline_date() {
        return pay_deadline_date;
    }

    public void setPay_deadline_date(String pay_deadline_date) {
        this.pay_deadline_date = pay_deadline_date;
    }

    public FeeInfoAllDto getFee_info_all() {
        return fee_info_all;
    }

    public void setFee_info_all(FeeInfoAllDto fee_info_all) {
        this.fee_info_all = fee_info_all;
    }

    public String getCost_slow_rate_annul() {
        return cost_slow_rate_annul;
    }

    public void setCost_slow_rate_annul(String cost_slow_rate_annul) {
        this.cost_slow_rate_annul = cost_slow_rate_annul;
    }

    public String getCost_slow_rate_review() {
        return cost_slow_rate_review;
    }

    public void setCost_slow_rate_review(String cost_slow_rate_review) {
        this.cost_slow_rate_review = cost_slow_rate_review;
    }
}
