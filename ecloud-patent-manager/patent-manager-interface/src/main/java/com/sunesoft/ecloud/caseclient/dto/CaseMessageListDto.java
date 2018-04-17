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

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

}
