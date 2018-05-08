package com.sunesoft.ecloud.caseclient.dto;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 合同详情dto
 */
public class ContractDetailDto extends ContractDto {


    /**
     * 合同案件列表
     */
    private List<ContractPatentInfo> patentInfoList;

    public List<ContractPatentInfo> getPatentInfoList() {
        return patentInfoList;
    }

    public void setPatentInfoList(List<ContractPatentInfo> patentInfoList) {
        this.patentInfoList = patentInfoList;
    }
}
