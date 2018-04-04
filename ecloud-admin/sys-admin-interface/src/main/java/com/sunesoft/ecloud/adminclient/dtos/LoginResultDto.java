package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.LoginResultStatus;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/4/004
 */
public class LoginResultDto {

    /**
     * 用户id
     */
    private UUID id;

    /**
     * 登录状态
     */
    private LoginResultStatus status;

    /**
     * 如果登录失败，id为null
     * @param id id
     * @param status 登录状态
     */
    public LoginResultDto(UUID id, LoginResultStatus status) {
        this.id = id;
        this.status = status;
    }
}
