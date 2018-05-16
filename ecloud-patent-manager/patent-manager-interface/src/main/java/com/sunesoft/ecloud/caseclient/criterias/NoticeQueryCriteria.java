package com.sunesoft.ecloud.caseclient.criterias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 通知书查询参数
 */
public class NoticeQueryCriteria extends TCretiria {

    /**
     * 企业id
     */
    private UUID agId;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }
}
