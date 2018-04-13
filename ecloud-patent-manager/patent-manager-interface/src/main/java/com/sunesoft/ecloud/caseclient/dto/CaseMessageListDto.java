package com.sunesoft.ecloud.caseclient.dto;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseMessageListDto extends CaseMessageDto{

    /**
     * 留言时间
     */
    private String messageDate;

    /**
     * 留言人真实姓名
     */
    private String messagerRealName;

    /**
     * 留言人角色名
     */
    private String messagerRoleName;

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

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
}
