package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@Entity
@Table(name = "pat_flow")
public class PatFlow extends IEntity{

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     * 路程节点
     */
    private String flowNode;

    /**
     *节点开始时间
     */
    private LocalDate nodeStartDate;

    /**
     *节点状态
     */
    private boolean nodeStatus;


    /**
     * 节点指定截止时间
     */
    private LocalDate nodeScheduleEndDate;

    /**
     *节点结束时间
     */
    private LocalDate nodeFinishDate;

    /**
     *经办人
     */
    private UUID operatorId;

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public String getFlowNode() {
        return flowNode;
    }

    public void setFlowNode(String flowNode) {
        this.flowNode = flowNode;
    }

    public LocalDate getNodeStartDate() {
        return nodeStartDate;
    }

    public void setNodeStartDate(LocalDate nodeStartDate) {
        this.nodeStartDate = nodeStartDate;
    }

    public boolean isNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(boolean nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public LocalDate getNodeScheduleEndDate() {
        return nodeScheduleEndDate;
    }

    public void setNodeScheduleEndDate(LocalDate nodeScheduleEndDate) {
        this.nodeScheduleEndDate = nodeScheduleEndDate;
    }

    public LocalDate getNodeFinishDate() {
        return nodeFinishDate;
    }

    public void setNodeFinishDate(LocalDate nodeFinishDate) {
        this.nodeFinishDate = nodeFinishDate;
    }

    public UUID getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(UUID operatorId) {
        this.operatorId = operatorId;
    }
}
