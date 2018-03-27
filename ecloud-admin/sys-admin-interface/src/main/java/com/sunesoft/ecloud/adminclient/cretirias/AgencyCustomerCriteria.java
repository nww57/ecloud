package com.sunesoft.ecloud.adminclient.cretirias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 */
public class AgencyCustomerCriteria extends TCretiria{

    /**
     * 企业id
     */
    private UUID agId;
    /**
     * 关键字
     */
    private String keywords;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
