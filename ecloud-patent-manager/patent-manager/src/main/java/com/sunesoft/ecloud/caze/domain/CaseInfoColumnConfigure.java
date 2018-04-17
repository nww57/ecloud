package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/17/017
 * 案件查询自定义列表项
 */
@Entity
@Table(name = "case_column_config")
public class CaseInfoColumnConfigure extends IEntity{

    @Column(name = "userId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID userId;

    @Column(name = "configure",columnDefinition="TEXT")
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
