package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseMessageDto {

    private UUID id;


    /**
     * 案件id
     */
    private UUID caseId;

    /**
     * 留言人id
     */
    private UUID messagerId;

    /**
     * 留言人姓名
     */
    private String messagerRealName;

    /**
     * 留言人角色名
     */
    private String messagerRoleName;

    /**
     * 留言内容
     */
    private String content;

    public String getMessagerRealName() {
        return messagerRealName;
    }

    public void setMessagerRealName(String messagerRealName) {
        this.messagerRealName = messagerRealName;
    }

    public String getMessagerRoleName() {
        return messagerRoleName;
    }

    public void setMessagerRoleName(String messagerRoleName) {
        this.messagerRoleName = messagerRoleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getCaseId() {
        return caseId;
    }

    public void setCaseId(UUID caseId) {
        this.caseId = caseId;
    }

    public UUID getMessagerId() {
        return messagerId;
    }

    public void setMessagerId(UUID messagerId) {
        this.messagerId = messagerId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
