package com.sunesoft.ecloud.hibernate;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/22
 */
@MappedSuperclass
public abstract   class BizEntity extends IEntity {

    @Column(name = "agId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID agId;


    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }
}
