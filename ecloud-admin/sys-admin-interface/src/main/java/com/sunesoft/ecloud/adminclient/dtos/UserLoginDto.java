package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.UserType;

import java.util.Date;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/2/002
 */
public class UserLoginDto {

    private UUID id;
    /**
     * 所属企业id
     */
    private UUID agId;
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
     *是否在职
     *
     * ture:在职  false:离职
     */
    private Boolean isWorkon;


    private Date lastPasswordResetDate;
    /**
     * 下次登录时是否需要重置密码
     */
    private Boolean needChangePassword;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
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

    public Boolean getWorkon() {
        return isWorkon;
    }

    public void setWorkon(Boolean workon) {
        isWorkon = workon;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Boolean getNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(Boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }
}
