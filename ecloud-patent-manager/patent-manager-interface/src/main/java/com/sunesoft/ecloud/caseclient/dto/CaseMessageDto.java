package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseMessageDto {

    /**
     * 留言人id
     */
    private UUID userId;

    /**
     * 留言内容
     */
    private String content;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
