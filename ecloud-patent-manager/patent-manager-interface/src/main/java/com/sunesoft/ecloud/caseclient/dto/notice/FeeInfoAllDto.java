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
    private BigDecimal fee_total;

    /**
     * 费用信息
     */
    private List<FeeInfoDetailDto> fee_info;

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
