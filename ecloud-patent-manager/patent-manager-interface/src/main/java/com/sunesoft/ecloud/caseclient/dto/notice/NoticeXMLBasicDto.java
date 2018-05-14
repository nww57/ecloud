package com.sunesoft.ecloud.caseclient.dto.notice;

/**
 * 通知书xml基础信息
 */
public class NoticeXMLBasicDto {

    /**
     *通知书名称
     */
    private String notice_name;

    /**
     *邮编
     */
    private String postcode;

    /**
     *收件人地址
     */
    private String address_info;

    /**
     * 收件人姓名
     */
    private String receiver_name;


    /**
     * 通知书发文信息
     */
    private NoticeSentInfoDto notice_sent;

    /**
     *申请号或专利号
     */
    private String application_number;

    /**
     *审查员
     */
    private String examiner_name;

    /**
     *审查部门
     */
    private String department;

    /**
     *联系电话
     */
    private String phone;

    /**
     *通知书模板代码
     */
    private String notice_template_code;

    /**
     *通知书版本号
     */
    private String notice_version;

    public String getNotice_name() {
        return notice_name;
    }

    public void setNotice_name(String notice_name) {
        this.notice_name = notice_name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress_info() {
        return address_info;
    }

    public void setAddress_info(String address_info) {
        this.address_info = address_info;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public NoticeSentInfoDto getNotice_sent() {
        return notice_sent;
    }

    public void setNotice_sent(NoticeSentInfoDto notice_sent) {
        this.notice_sent = notice_sent;
    }

    public String getApplication_number() {
        return application_number;
    }

    public void setApplication_number(String application_number) {
        this.application_number = application_number;
    }

    public String getExaminer_name() {
        return examiner_name;
    }

    public void setExaminer_name(String examiner_name) {
        this.examiner_name = examiner_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotice_template_code() {
        return notice_template_code;
    }

    public void setNotice_template_code(String notice_template_code) {
        this.notice_template_code = notice_template_code;
    }

    public String getNotice_version() {
        return notice_version;
    }

    public void setNotice_version(String notice_version) {
        this.notice_version = notice_version;
    }
}
