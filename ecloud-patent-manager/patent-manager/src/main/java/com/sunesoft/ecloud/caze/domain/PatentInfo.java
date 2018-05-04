package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.caseclient.enums.TechnologyEnum;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 合同专利信息
 */
@Entity
@Table(name = "pat_contract_patent_info", schema = "springcloud", catalog = "")
public class PatentInfo extends IEntity{

    /**
     * 所属合同
     */
    @ManyToOne
    @JoinColumn(name = "contractId")
    private ContractInfo contractInfo;


    /**
     * 所属客户
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;

    /**
     *申请号
     */
    @Column(name = "applicationNo")
    private String applicationNo;

    /**
     *申请日
     */
    @Column(name = "applicationDate")
    private LocalDate applicationDate;

    /**
     *授权日
     */
    @Column(name = "authorizationDate")
    private LocalDate authorizationDate;

    /**
     *案件号
     */
    @Column(name = "caseNo")
    private String caseNo;

    /**
     *案件状态
     */
    @Column(name = "caseStatus")
    private String caseStatus;

    /**
     *专利类型
     */
    @Column(name = "patentType")
    private String patentType;

    /**
     *专利名称
     */
    @Column(name = "patentName")
    private String patentName;

    /**
     *主分类号
     */
    @Column(name = "mainClassificationNumber")
    private String mainClassificationNumber;

    /**
     *分案提交日
     */
    @Column(name = "applicationSubmissionDate")
    private LocalDate applicationSubmissionDate;

    /**
     *申请人
     */
    @Column(name = "applicants")
    private String applicants;

    /**
     *发明人
     */
    @Column(name = "inventors")
    private String inventors;

    /**
     *代理机构
     */
    @Column(name = "agency")
    private String agency;

    /**
     *代理人
     */
    @Column(name = "agencyAgents")
    private String agencyAgents;

    /**
     *技术领域
     */
    @Column(name = "techDomain")
    private TechnologyEnum techDomain;

    /**
     *费减比列
     */
    @Column(name = "feeReduceRate")
    private Integer feeReduceRate;

    /**
     *官费
     */
    @Column(name = "officialPrice")
    private BigDecimal officialPrice;

    /**
     *代理费
     */
    @Column(name = "agencyPrice")
    private BigDecimal agencyPrice;

    /**
     *总费用
     */
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    /**
     * 是否同日申请
     */
    @Column(name = "isApplicationSameDay")
    private boolean isApplicationSameDay;

    /**
     * 同日申请案件号
     */
    @Column(name = "applicationSameDayCaseNo")
    private String applicationSameDayCaseNo;

    @OneToOne
    private PatActor patActor;

    public ContractInfo getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(ContractInfo contractInfo) {
        this.contractInfo = contractInfo;
    }


    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(LocalDate authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getMainClassificationNumber() {
        return mainClassificationNumber;
    }

    public void setMainClassificationNumber(String mainClassificationNumber) {
        this.mainClassificationNumber = mainClassificationNumber;
    }

    public LocalDate getApplicationSubmissionDate() {
        return applicationSubmissionDate;
    }

    public void setApplicationSubmissionDate(LocalDate applicationSubmissionDate) {
        this.applicationSubmissionDate = applicationSubmissionDate;
    }

    public String getApplicants() {
        return applicants;
    }

    public void setApplicants(String applicants) {
        this.applicants = applicants;
    }

    public String getInventors() {
        return inventors;
    }

    public void setInventors(String inventors) {
        this.inventors = inventors;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgencyAgents() {
        return agencyAgents;
    }

    public void setAgencyAgents(String agencyAgents) {
        this.agencyAgents = agencyAgents;
    }

    public TechnologyEnum getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(TechnologyEnum techDomain) {
        this.techDomain = techDomain;
    }

    public Integer getFeeReduceRate() {
        return feeReduceRate;
    }

    public void setFeeReduceRate(Integer feeReduceRate) {
        this.feeReduceRate = feeReduceRate;
    }

    public BigDecimal getOfficialPrice() {
        return officialPrice;
    }

    public void setOfficialPrice(BigDecimal officialPrice) {
        this.officialPrice = officialPrice;
    }

    public BigDecimal getAgencyPrice() {
        return agencyPrice;
    }

    public void setAgencyPrice(BigDecimal agencyPrice) {
        this.agencyPrice = agencyPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PatActor getPatActor() {
        return patActor;
    }

    public void setPatActor(PatActor patActor) {
        this.patActor = patActor;
    }

    public boolean isApplicationSameDay() {
        return isApplicationSameDay;
    }

    public void setApplicationSameDay(boolean applicationSameDay) {
        isApplicationSameDay = applicationSameDay;
    }

    public String getApplicationSameDayCaseNo() {
        return applicationSameDayCaseNo;
    }

    public void setApplicationSameDayCaseNo(String applicationSameDayCaseNo) {
        this.applicationSameDayCaseNo = applicationSameDayCaseNo;
    }
}
