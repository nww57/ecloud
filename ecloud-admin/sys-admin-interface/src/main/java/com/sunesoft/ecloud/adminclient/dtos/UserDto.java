package com.sunesoft.ecloud.adminclient.dtos;


import java.util.*;
/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public class UserDto {

    private UUID Id;
    /**
     * 组织机构Id
     */
    private UUID orgId;
    /**
     * 组织机构名称
     */
    private UUID orgName;
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

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getOrgId() {
        return orgId;
    }

    public void setOrgId(UUID orgId) {
        this.orgId = orgId;
    }

    public UUID getOrgName() {
        return orgName;
    }

    public void setOrgName(UUID orgName) {
        this.orgName = orgName;
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
