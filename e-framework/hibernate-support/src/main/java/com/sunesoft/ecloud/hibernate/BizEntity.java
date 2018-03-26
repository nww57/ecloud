package com.sunesoft.ecloud.hibernate;


import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/22
 */
public abstract class BizEntity extends IEntity {

    private UUID agId;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }
}
