package com.sunesoft.ecloud.caseclient.dto.notice;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/15/015
 * 办理登记手续通知书
 */
@XStreamAlias("cn_notice_info")
public class CheckInNoticeDto extends NoticeXMLBasicDto{
    /**
     *缴费截止日期
     */
    private String pay_deadline_date;

    /**
     * 所有费用信息
     */
    private FeeInfoAllDto fee_info_all;

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
}
