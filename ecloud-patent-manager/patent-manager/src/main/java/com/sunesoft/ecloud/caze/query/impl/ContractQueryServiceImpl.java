package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.caseclient.criterias.ContractQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.ContractDetailDto;
import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.caseclient.dto.ContractPatentInfo;
import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.caze.query.ContractQueryService;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@Service
public class ContractQueryServiceImpl extends GenericQuery implements ContractQueryService {


    @Override
    public PagedResult<ContractDto> queryContractPaged(ContractQueryCriteria criteria) {
        if (null == criteria.getAgId()) {
            throw new IllegalArgumentException("企业id不能为null");
        }
        StringBuilder sb = new StringBuilder("select " +
                " pci.id," +
                " pci.contractNo," +
                " pci.contractName," +
                " pci.signDate," +
                " pci.create_datetime createDate," +
                " pci.totalPrice," +
                " pci.officialFeeTotalPrice," +
                " pci.agencyFeeTotalPrice," +
                " pci.invoicedPrice," +
                " pci.unpaidPrice," +
                " pci.paidPrice," +
                " pci.uninvoicedPrice," +
                " pci.customerId," +
                " ac.name customerName," +
                " pci.salesmanId," +
                " u.realName salesmanName," +
                " pci.middlemanFee," +
                " pci.creatorId," +
                " u2.realName creatorName" +
                " from pat_contract_info pci " +
                " LEFT JOIN sys_ag_customer ac on ac.id = pci.customerId" +
                " LEFT JOIN sys_user u on u.id = pci.salesmanId" +
                " left JOIN sys_user u2 on u2.id = pci.creatorId" +
                " where pci.is_active = 1");
        sb.append(" and pci.agId = :agId");
        Map<String, Object> param = new HashMap<>();
        param.put("agId", criteria.getAgId()+"");
        if (StringUtils.isNotEmpty(criteria.getContractNo())) {
            sb.append(" and pci.contractNo like :contractNo");
            param.put("contractNo", criteria.getContractNo());
        }
        if (StringUtils.isNotEmpty(criteria.getContractName())) {
            sb.append(" and pci.contractName like :contractName");
            param.put("contractName", criteria.getContractName());
        }
        if (StringUtils.isNotEmpty(criteria.getCustomerName())) {
            sb.append(" and ac.name like :customerName");
            param.put("customerName", criteria.getContractName());
        }
        if (StringUtils.isNotEmpty(criteria.getCreatorName())) {
            sb.append(" and u2.realName like :creatorName");
            param.put("creatorName", criteria.getCreatorName());
        }
        if (StringUtils.isNotEmpty(criteria.getCreateDateStart())) {
            sb.append(" and pci.create_datetime >= :createDateStart");
            param.put("createDateStart", criteria.getCreateDateStart());
        }
        if (StringUtils.isNotEmpty(criteria.getCreateDateEnd())) {
            sb.append(" and pci.create_datetime <= :createDateEnd");
            param.put("createDateEnd", criteria.getCreateDateEnd());
        }
        return queryPaged(criteria.getPageIndex(),criteria.getPageSize(),sb.toString(),param,ContractDto.class);
    }

    @Override
    public TResult<ContractDetailDto> getContractDetailById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("无效的参数id");
        }
        //获取基本信息
        StringBuilder sb = new StringBuilder("select " +
                " pci.id," +
                " pci.contractNo," +
                " pci.contractName," +
                " pci.signDate," +
                " pci.create_datetime createDate," +
                " pci.totalPrice," +
                " pci.officialFeeTotalPrice," +
                " pci.agencyFeeTotalPrice," +
                " pci.invoicedPrice," +
                " pci.unpaidPrice," +
                " pci.paidPrice," +
                " pci.uninvoicedPrice," +
                " pci.customerId," +
                " ac.name customerName," +
                " pci.salesmanId," +
                " u.realName salesmanName," +
                " pci.middlemanFee " +
                " from pat_contract_info pci " +
                " LEFT JOIN sys_ag_customer ac on ac.id = pci.customerId" +
                " LEFT JOIN sys_user u on u.id = pci.salesmanId" +
                " where pci.is_active = 1 and pci.id = '"+id+"'");
        ContractDetailDto dto = queryForObject(sb.toString(),null,ContractDetailDto.class);
        //获取合同专利
        SqlBuilder<ContractPatentInfo> dtoBuilder = HSqlBuilder.hFrom(PatentInfo.class, "p")
                .where("p.contractId",id)
                .select(ContractPatentInfo.class);
        List<ContractPatentInfo> patentList = queryList(dtoBuilder);
        dto.setPatentInfoList(patentList);
        return new TResult<>(dto);
    }
}
