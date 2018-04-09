package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.LoginResultStatus;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/4/004
 */
public class LoginResultDto {

    /**
     * 用户信息
     * 登录成功则有信息，登录失败则为null
     */
    private UserLoginDto userInfo;

    /**
     * 登录状态
     */
    private LoginResultStatus status;

    /**
     * 如果登录失败，userInfo为null
     * @param userInfo 用户信息
     * @param status 登录状态
     */
    public LoginResultDto(UserLoginDto userInfo, LoginResultStatus status) {
        this.userInfo = userInfo;
        this.status = status;
    }

    public UserLoginDto getUserInfo() {
        return userInfo;
    }

    public LoginResultStatus getStatus() {
        return status;
    }
}
