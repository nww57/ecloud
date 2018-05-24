package com.sunesoft.ecloud.caseclient.criterias;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/9/009
 */
public class PatentNodeQueryCriteria extends TCretiria {

    private UUID agId;

    /**
     * 用户id
     */
    private UUID userId;

    /**
     * 专利节点
     */
    private PatentNode patentNode;

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public PatentNode getPatentNode() {
        return patentNode;
    }

    public void setPatentNode(PatentNode patentNode) {
        this.patentNode = patentNode;
    }
}
