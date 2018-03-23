package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.admin.domain.Orgnization;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 * 用户
 */
@Entity
@Table(name="sys_user")
public class User extends IEntity{

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 电话号码
     */
    private String phoneNo;
    /**
     * 邮箱
     */
    private String email;

    @ManyToOne
    @JoinColumn(name = "orgId")
    private Orgnization orgnization;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
