package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/12
 */
@Entity
@Table(name = "case_cust_require")
public class CaseCustomerRequest extends IEntity{

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "caseId")
    private CaseInfo caseInfo;

    /**
     *要求类型
     */
    @Column(name = "type")
    private String type;

    /**
     *标题
     */
    @Column(name = "title")
    private String title;

    /**
     *描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 文件（预留）
     */
    @Column(name = "fileId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID fileId;

    public CaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getFileId() {
        return fileId;
    }

    public void setFileId(UUID fileId) {
        this.fileId = fileId;
    }
}
