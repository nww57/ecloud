//package com.sunesoft.ecloud.caze.domain;
//
//import com.sunesoft.ecloud.hibernate.IEntity;
//import org.hibernate.annotations.Type;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.UUID;
//
///**
// * @Auther: niww
// * @Date: 2018/5/4/004
// * 专利流程参与人员
// */
//@Entity
//@Table(name = "pat_actor")
//public class PatActor extends IEntity{
//
//    /**
//     * 所属专利
//     */
//    @OneToOne
//    @JoinColumn(name = "patentId")
//    private PatentInfo patentInfo;
//
//    /**
//     * 立案人
//     */
//    @Column(name = "caseCreatorId",columnDefinition = "char(36)")
//    @Type(type = "uuid-char")
//    private UUID caseCreatorId;
//
//    /**
//     *工程师组长
//     */
//    @Column(name = "engineerLeaderId",columnDefinition = "char(36)")
//    @Type(type = "uuid-char")
//    private UUID engineerLeaderId;
//
//    /**
//     *工程师/撰写人
//     */
//    @Column(name = "engineerId",columnDefinition = "char(36)")
//    @Type(type = "uuid-char")
//    private UUID engineerId;
//
//    /**
//     *撰写截止日
//     */
//    @Column(name = "writeExpiryDate")
//    private LocalDate writeExpiryDate;
//
//    /**
//     *打包人
//     */
//    @Column(name = "packagerId",columnDefinition = "char(36)")
//    @Type(type = "uuid-char")
//    private UUID packagerId;
//
//    /**
//     *缴费人
//     */
//    @Column(name = "payerId",columnDefinition = "char(36)")
//    @Type(type = "uuid-char")
//    private UUID payerId;
//
//    public PatentInfo getPatentInfo() {
//        return patentInfo;
//    }
//
//    public void setPatentInfo(PatentInfo patentInfo) {
//        this.patentInfo = patentInfo;
//    }
//
//    public UUID getCaseCreatorId() {
//        return caseCreatorId;
//    }
//
//    public void setCaseCreatorId(UUID caseCreatorId) {
//        this.caseCreatorId = caseCreatorId;
//    }
//
//    public UUID getEngineerLeaderId() {
//        return engineerLeaderId;
//    }
//
//    public void setEngineerLeaderId(UUID engineerLeaderId) {
//        this.engineerLeaderId = engineerLeaderId;
//    }
//
//    public UUID getEngineerId() {
//        return engineerId;
//    }
//
//    public void setEngineerId(UUID engineerId) {
//        this.engineerId = engineerId;
//    }
//
//    public LocalDate getWriteExpiryDate() {
//        return writeExpiryDate;
//    }
//
//    public void setWriteExpiryDate(LocalDate writeExpiryDate) {
//        this.writeExpiryDate = writeExpiryDate;
//    }
//
//    public UUID getPackagerId() {
//        return packagerId;
//    }
//
//    public void setPackagerId(UUID packagerId) {
//        this.packagerId = packagerId;
//    }
//
//    public UUID getPayerId() {
//        return payerId;
//    }
//
//    public void setPayerId(UUID payerId) {
//        this.payerId = payerId;
//    }
//}
