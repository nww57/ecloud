package com.sunesoft.ecloud.caseclient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 合同管理Dto
 */
public class ContractDto {

    private UUID id;

    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 合同名称
     */
    private String contractName;
    /**
     *客户id
     */
    private UUID customerId;
    /**
     * 客户姓名
     */
    private String customerName;

    /**
     *业务销售人员/案源人
     */
    private UUID salesmanId;


    /**
     *业务销售人员/案源人 姓名
     */
    private String salesmanName;

    /**
     *介绍费
     */
    private BigDecimal middlemanFee;
    /**
     *签约日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate signDate;
    /**
     *合同总金额
     */
    private BigDecimal totalPrice;
    /**
     *官费合计
     */
    private BigDecimal officialFeeTotalPrice;
    /**
     *代理费合计
     */
    private BigDecimal agencyFeeTotalPrice;
    /**
     *已开票金额
     */
    private BigDecimal invoicedPrice;
    /**
     *未开票金额
     */
    private BigDecimal uninvoicedPrice;
    /**
     *已付款金额
     */
    private BigDecimal paidPrice;
    /**
     *未付款金额
     */
    private BigDecimal unpaidPrice;

    /**
     * 创建人id
     */
    private UUID creatorId;

    /**
     * 创建人姓名
     */
    private String creatorName;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
}
