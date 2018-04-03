package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.adminclient.UserType;
import com.sunesoft.ecloud.hibernate.BizEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Enumerated(EnumType.STRING)
    private UserType userType;
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
     * 地区code
     */
    @Column(name = "addressCode")
    private String addressCode;
    /**
     * 省
     */
    @Column(name = "province")
    private String province;
    /**
     *市
     */
    @Column(name = "city")
    private String city;
    /**
     *区
     */
    @Column(name = "district")
    private String district;
    /**
     *街道
     */
    @Column(name = "street")
    private String street;

    /**
     * 职位
     */
    @Column(name = "position")
    private String position;
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
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    @JoinTable(name = "sys_ag_user_role",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<AgencyRole> roleList = new ArrayList<>();

    @Column(name = "agId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID agencyId;

    /**
     * 下次登录时是否需要重置密码
     */
    @Column(name = "needChangePassword")
    private Boolean needChangePassword;

    public User() {
        this.userType = UserType.AGENCY_USER;
    }

    public User(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
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

    public Boolean getIsWorkon() {
        return isWorkon;
    }

    public void setIsWorkon(Boolean workon) {
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

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UUID getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(UUID agencyId) {
        this.agencyId = agencyId;
    }



    public Boolean getNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(Boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }
}
