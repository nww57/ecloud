package com.sunesoft.ecloud.caseclient.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 * 审批意见
 */
public class ApprovalOpinion {

    @XStreamAlias("审核意见")
    private String opinion;

    @XStreamAlias("提交日期")
    private XMLDate submitDate;

    public ApprovalOpinion(String opinion, XMLDate submitDate) {
        this.opinion = opinion;
        this.submitDate = submitDate;
    }
}
