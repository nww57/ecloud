package com.sunesoft.ecloud.caseclient.dto.notice;

import java.math.BigDecimal;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/14/014
 */
public class FeeInfoAllDto {

    /**
     * 费用金额总计
     */
    private BigDecimal fee_total = BigDecimal.ZERO;

    /**
     * 费用信息
     */
    private List<FeeInfoDetailDto> fee_info;


    //以下4个字段是办理登记手续通知书中出现

    /**
     *已缴费用
     */
    private BigDecimal fee_paid = BigDecimal.ZERO;

    /**
     *应缴费用
     */
    private BigDecimal fee_payable = BigDecimal.ZERO;

    /**
     *缴纳年费年度
     */
    private String annual_year;

    /**
     *减缓标记
     */
    private String cost_slow_flag;

    public BigDecimal getFee_paid() {
        return fee_paid;
    }

    public void setFee_paid(BigDecimal fee_paid) {
        this.fee_paid = fee_paid;
    }

    public BigDecimal getFee_payable() {
        return fee_payable;
    }

    public void setFee_payable(BigDecimal fee_payable) {
        this.fee_payable = fee_payable;
    }

    public String getAnnual_year() {
        return annual_year;
    }

    public void setAnnual_year(String annual_year) {
        this.annual_year = annual_year;
    }

    public String getCost_slow_flag() {
        return cost_slow_flag;
    }

    public void setCost_slow_flag(String cost_slow_flag) {
        this.cost_slow_flag = cost_slow_flag;
    }

    public BigDecimal getFee_total() {
        return fee_total;
    }

    public void setFee_total(BigDecimal fee_total) {
        this.fee_total = fee_total;
    }

    public List<FeeInfoDetailDto> getFee_info() {
        return fee_info;
    }

    public void setFee_info(List<FeeInfoDetailDto> fee_info) {
        this.fee_info = fee_info;
    }
}
