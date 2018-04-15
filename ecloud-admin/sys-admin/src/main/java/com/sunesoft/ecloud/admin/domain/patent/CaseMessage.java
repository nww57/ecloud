package com.sunesoft.ecloud.admin.domain.patent;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "case_message")
public class CaseMessage extends IEntity {

    @ManyToOne
    @JoinColumn(name = "caseId")
    private CaseInfo caseInfo;

    /**
     * 留言人角色名
     */
    @Column(name = "messagerRoleName")
    private String messagerRoleName;

    /**
     *留言人真实姓名
     */
    @Column(name = "messagerRealName")
    private String messagerRealName;

    /**
     *留言内容
     */
    @Column(name = "content")
    private String content;

    public CaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public String getMessagerRoleName() {
        return messagerRoleName;
    }

    public void setMessagerRoleName(String messagerRoleName) {
        this.messagerRoleName = messagerRoleName;
    }

    public String getMessagerRealName() {
        return messagerRealName;
    }

    public void setMessagerRealName(String messagerRealName) {
        this.messagerRealName = messagerRealName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
