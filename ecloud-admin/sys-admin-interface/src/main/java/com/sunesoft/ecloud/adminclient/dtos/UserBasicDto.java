package com.sunesoft.ecloud.adminclient.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunesoft.ecloud.adminclient.UserType;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/2/002
 */
public class UserBasicDto extends BasicDto{

    /**
     *用户类型
     */
    private UserType userType;

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
     *
     * ture:在职  false:离职
     */
    private Boolean isWorkon;

    /**
     * 地区code
     */
    private String addressCode;
    /**
     * 省
     */
    private String province;
    /**
     *市
     */
    private String city;
    /**
     *区
     */
    private String district;
    /**
     *街道
     */
    private String street;

    /**
     * 职位
     */
    private String position;


    /**
     * 创建时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    /**
     * 所属企业id
     */
    private UUID agId;

    private Boolean needChangePassword;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public Boolean getNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(Boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }
}
