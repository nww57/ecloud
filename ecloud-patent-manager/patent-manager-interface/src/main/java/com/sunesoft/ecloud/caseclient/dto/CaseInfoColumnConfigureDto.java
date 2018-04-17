package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/17/017
 * 案件查询列表自定义配置
 */
public class CaseInfoColumnConfigureDto {

    /**
     * 用户id
     */
    private UUID userId;

    /**
     * 配置项
     */
    private String configure;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getConfigure() {
        return configure;
    }

    public void setConfigure(String configure) {
        this.configure = configure;
    }
}
