package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@Entity
@Table(name = "pat_contract_info", schema = "springcloud", catalog = "")
public class ContractInfo extends BizEntity{

    /**
     * 合同编号
     */
    @Column(name = "contractNo")
    private String contractNo;
    /**
     * 合同名称
     */
    @Column(name = "contractName")
    private String contractName;
    /**
     *客户id
     */
    @Column(name = "customerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID customerId;
    /**
     *业务销售人员
     */
    @Column(name = "salesmanId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID salesmanId;

    /**
     *案源人
     */
    @Column(name = "introducerId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID introducerId;
    /**
     *介绍费
     */
    @Column(name = "middlemanFee")
    private BigDecimal middlemanFee;
    /**
     *签约日期
     */
    @Column(name = "signDate")
    private LocalDate signDate;
    /**
     *合同总金额
     */
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;
    /**
     *官费合计
     */
    @Column(name = "officialFeeTotalPrice")
    private BigDecimal officialFeeTotalPrice;
    /**
     *代理费合计
     */
    @Column(name = "agencyFeeTotalPrice")
    private BigDecimal agencyFeeTotalPrice;
    /**
     *已开票金额
     */
    @Column(name = "invoicedPrice")
    private BigDecimal invoicedPrice;
    /**
     *未开票金额
     */
    @Column(name = "uninvoicedPrice")
    private BigDecimal uninvoicedPrice;
    /**
     *已付款金额
     */
    @Column(name = "paidPrice")
    private BigDecimal paidPrice;
    /**
     *未付款金额
     */
    @Column(name = "unpaidPrice")
    private BigDecimal unpaidPrice;

    /**
     *业务销售人员/案源人
     */
    @Column(name = "creatorId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID creatorId;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(UUID salesmanId) {
        this.salesmanId = salesmanId;
    }

    public BigDecimal getMiddlemanFee() {
        return middlemanFee;
    }

    public void setMiddlemanFee(BigDecimal middlemanFee) {
        this.middlemanFee = middlemanFee;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getOfficialFeeTotalPrice() {
        return officialFeeTotalPrice;
    }

    public void setOfficialFeeTotalPrice(BigDecimal officialFeeTotalPrice) {
        this.officialFeeTotalPrice = officialFeeTotalPrice;
    }

    public BigDecimal getAgencyFeeTotalPrice() {
        return agencyFeeTotalPrice;
    }

    public void setAgencyFeeTotalPrice(BigDecimal agencyFeeTotalPrice) {
        this.agencyFeeTotalPrice = agencyFeeTotalPrice;
    }

    public BigDecimal getInvoicedPrice() {
        return invoicedPrice;
    }

    public void setInvoicedPrice(BigDecimal invoicedPrice) {
        this.invoicedPrice = invoicedPrice;
    }

    public BigDecimal getUninvoicedPrice() {
        return uninvoicedPrice;
    }

    public void setUninvoicedPrice(BigDecimal uninvoicedPrice) {
        this.uninvoicedPrice = uninvoicedPrice;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public BigDecimal getUnpaidPrice() {
        return unpaidPrice;
    }

    public void setUnpaidPrice(BigDecimal unpaidPrice) {
        this.unpaidPrice = unpaidPrice;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }

    public UUID getIntroducerId() {
        return introducerId;
    }

    public void setIntroducerId(UUID introducerId) {
        this.introducerId = introducerId;
    }
}
