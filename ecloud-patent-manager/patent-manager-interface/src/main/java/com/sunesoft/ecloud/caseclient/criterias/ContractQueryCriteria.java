package com.sunesoft.ecloud.caseclient.criterias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;

/**
 * @Author: niww
 * @Date: 2018/5/3
 * 合同查询参数
 */
public class ContractQueryCriteria extends TCretiria{

    /**
     *合同编号
     */
    private String contractNo;

    /**
     *合同名称
     */
    private String contractName;

    /**
     *客户名称
     */
    private String customerName;

    /**
     *创建人
     */
    private String creatorName;

    /**
     *创建时间 -开始
     */
    private String createDateStart;

    /**
     * 创建时间 -结束
     */
    private String createDateEnd;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(String createDateStart) {
        this.createDateStart = createDateStart;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }
}
