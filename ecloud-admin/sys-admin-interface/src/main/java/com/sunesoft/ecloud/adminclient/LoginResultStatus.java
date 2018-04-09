package com.sunesoft.ecloud.adminclient;

/**
 * @Auther: niww
 * @Date: 2018/4/4/004
 */
public enum LoginResultStatus {
    /**
     * 登录成功
     */
    SUCCESS,
    /**
     * 用户名不存在
     */
    ERROR_USERNAME,
    /**
     * 密码错误
     */
    ERROR_PASSWORD,
    /**
     * 企业服务已到期
     */
    SERVER_EXPIRED


}
