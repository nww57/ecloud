package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentNode;

import java.time.LocalDate;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 * 专利流程记录
 */
public class PatentFlowDto {

    /**
     * 流程节点
     */
    private PatentNode patentNode;

    /**
     *开始时间
     */
    private LocalDate nodeStartDate;

    /**
     *完成时间
     */
    private LocalDate nodeEndDate;

    /**
     *指定期限
     */
    private LocalDate nodeDueDate;

    /**
     *承办人
     */
    private String operator;

    /**
     *附件
     */
    private String attachment;


    public PatentNode getPatentNode() {
        return patentNode;
    }

    public void setPatentNode(PatentNode patentNode) {
        this.patentNode = patentNode;
    }

    public LocalDate getNodeStartDate() {
        return nodeStartDate;
    }

    public void setNodeStartDate(LocalDate nodeStartDate) {
        this.nodeStartDate = nodeStartDate;
    }

    public LocalDate getNodeEndDate() {
        return nodeEndDate;
    }

    public void setNodeEndDate(LocalDate nodeEndDate) {
        this.nodeEndDate = nodeEndDate;
    }

    public LocalDate getNodeDueDate() {
        return nodeDueDate;
    }

    public void setNodeDueDate(LocalDate nodeDueDate) {
        this.nodeDueDate = nodeDueDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
