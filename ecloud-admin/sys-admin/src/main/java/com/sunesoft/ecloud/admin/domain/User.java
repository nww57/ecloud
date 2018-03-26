package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 用户
 */
@Entity
@Table(name = "sys_user", schema = "ecloud", catalog = "")
public class User extends BizEntity{
    /**
     *用户类型
     */
    private String userType;
    /**
     *用户编号
     */
    private String userCode;
    /**
     *用户名
     */
    private String userName;
    /**
     *真实姓名
     */
    private String realName;
    /**
     *密码
     */
    private String password;
    /**
     *性别
     */
    private String sex;
    /**
     *邮箱
     */
    private String email;
    /**
     *联系电话
     */
    private String callphone;
    /**
     *是否在职
     */
    private Boolean isWorkon;
    /**
     *最后登录时间
     */
    private Date lastLoginDatetime;
    /**
     *最后登录IP
     */
    private String lastLoginIp;

    @ManyToOne
    @JoinColumn(name = "compId")
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<CompanyCustomer> customerList = new ArrayList<>();

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "sys_user_role_rel",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList = new ArrayList<>();

    @Basic
    @Column(name = "userType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "userCode")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "realName")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "callphone")
    public String getCallphone() {
        return callphone;
    }

    public void setCallphone(String callphone) {
        this.callphone = callphone;
    }

    @Basic
    @Column(name = "isWorkon")
    public Boolean getWorkon() {
        return isWorkon;
    }

    public void setWorkon(Boolean workon) {
        isWorkon = workon;
    }

    @Basic
    @Column(name = "lastLoginDatetime")
    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    @Basic
    @Column(name = "lastLoginIp")
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<CompanyCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CompanyCustomer> customerList) {
        this.customerList = customerList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }


}
