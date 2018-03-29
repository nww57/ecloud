package com.sunesoft.ecloud.adminclient.dtos;


import java.util.*;
/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public class UserDto extends BasicDto{



    /**
     *用户类型
     */
    private String userType;

    /**
     *用户名
     */
    private String userName;

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
    private String createDate;


    /**
     * 所属机构-id
     */
    private UUID organizationId;

    /**
     * 所属机构-名称
     */
    private String organizationName;

    /**
     *真实姓名
     */
    private String realName;

    /**
     * 角色Id
     */
    private List<UUID> roleIdList;

    /**
     * 角色名称
     */
    private List<String> roleNameList;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }



    public List<UUID> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<UUID> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
}
