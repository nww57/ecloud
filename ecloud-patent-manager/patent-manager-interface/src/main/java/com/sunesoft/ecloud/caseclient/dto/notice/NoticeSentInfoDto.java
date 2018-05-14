package com.sunesoft.ecloud.caseclient.dto.notice;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 通知书发文信息
 */
public class NoticeSentInfoDto {

    /**
     *发文序列号
     */
    private String notice_sent_serial;

    /**
     *发文日期
     */
    private String notice_sent_date;

    /**
     *发文类型
     */
    private String notice_sent_type;

    public String getNotice_sent_serial() {
        return notice_sent_serial;
    }

    public void setNotice_sent_serial(String notice_sent_serial) {
        this.notice_sent_serial = notice_sent_serial;
    }

    public String getNotice_sent_date() {
        return notice_sent_date;
    }

    public void setNotice_sent_date(String notice_sent_date) {
        this.notice_sent_date = notice_sent_date;
    }

    public String getNotice_sent_type() {
        return notice_sent_type;
    }

    public void setNotice_sent_type(String notice_sent_type) {
        this.notice_sent_type = notice_sent_type;
    }
}
