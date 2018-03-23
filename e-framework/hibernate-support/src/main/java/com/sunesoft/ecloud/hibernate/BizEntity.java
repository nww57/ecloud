package com.sunesoft.ecloud.hibernate;


import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/22
 */
public abstract class BizEntity extends IEntity {

    private UUID corpId;

    public UUID getCorpId() {
        return corpId;
    }

    public void setCorpId(UUID corpId) {
        this.corpId = corpId;
    }
}
