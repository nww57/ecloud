package com.sunesoft.ecloud.hibernate;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@MappedSuperclass
public class PatEntity extends IEntity{

    /**
     * 所属专利
     */
    @Column(name = "patentId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID patentId;

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }
}
