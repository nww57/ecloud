package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;

/**
 * @Auther: niww
 * @Date: 2018/5/7/007
 */
public class PatentNodeCountDto {

    private PatentNode patentNode;

    private Integer count;

    public PatentNode getPatentNode() {
        return patentNode;
    }

    public void setPatentNode(PatentNode patentNode) {
        this.patentNode = patentNode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
