package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jzj on 2018/4/11.
 * 客户联系人维护
 */
@Entity
@Table(name = "customer_contacts")
public class CustomerContact extends IEntity {

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 手机
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * QQ
     */
    @Column(name = "qq")
    private String qq;

    /**
     * 座机
     */
    @Column(name = "phone")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
