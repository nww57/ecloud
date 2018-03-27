package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.BizEntity;
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
@Table(name = "sys_user")
public class User extends BizEntity{
    /**
     *用户类型
     */
    @Column(name = "userType")
    private String userType;
    /**
     *用户编号
     */
    @Column(name = "userCode")
    private String userCode;
    /**
     *用户名
     */
    @Column(name = "userName")
    private String userName;
    /**
     *真实姓名
     */
    @Column(name = "realName")
    private String realName;
    /**
     *密码
     */
    @Column(name = "password")
    private String password;
    /**
     *性别
     */
    @Column(name = "sex")
    private String sex;
    /**
     *邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     *联系电话
     */
    @Column(name = "callphone")
    private String callphone;
    /**
     *是否在职
     */
    @Column(name = "isWorkon")
    private Boolean isWorkon;
    /**
     *最后登录时间
     */
    @Column(name = "lastLoginDatetime")
    private Date lastLoginDatetime;
    /**
     *最后登录IP
     */
    @Column(name = "lastLoginIp")
    private String lastLoginIp;

    @ManyToOne
    @JoinColumn(name = "structureId")
    private AgencyOrganization agencyOrganization;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "sys_ag_user_role",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<AgencyRole> roleList = new ArrayList<>();

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCallphone() {
        return callphone;
    }

    public void setCallphone(String callphone) {
        this.callphone = callphone;
    }

    public Boolean getWorkon() {
        return isWorkon;
    }

    public void setWorkon(Boolean workon) {
        isWorkon = workon;
    }

    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public AgencyOrganization getAgencyOrganization() {
        return agencyOrganization;
    }

    public void setAgencyOrganization(AgencyOrganization agencyOrganization) {
        this.agencyOrganization = agencyOrganization;
    }

    public List<AgencyRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<AgencyRole> roleList) {
        this.roleList = roleList;
    }


}
