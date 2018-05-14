package com.sunesoft.ecloud.caseclient.dto.notice;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

/**
 * @auther: niww
 * @date: 2018/5/14/014
 */
@XStreamAlias("fee")
public class FeeInfoDetailDto {

    /**
     * 费用名称
     */
    private String fee_name;

    /**
     * 费用金额
     */
    private BigDecimal fee_amount;

    public String getFee_name() {
        return fee_name;
    }

    public void setFee_name(String fee_name) {
        this.fee_name = fee_name;
    }

    public BigDecimal getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(BigDecimal fee_amount) {
        this.fee_amount = fee_amount;
    }
}
