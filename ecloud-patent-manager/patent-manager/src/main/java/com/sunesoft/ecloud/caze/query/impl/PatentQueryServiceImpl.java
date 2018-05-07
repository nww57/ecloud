package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.PatentQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caze.domain.*;
import com.sunesoft.ecloud.caze.query.PatentQueryService;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
@Service
public class PatentQueryServiceImpl extends GenericQuery implements PatentQueryService {

    @Override
    public TResult<Map<PatentNode, Integer>> getPatentNodeCount(UUID agId) {
        String sql  = "select patentNode,count(*) count  from pat_contract_patent_info p where p.agId = '"+agId+"' GROUP BY p.patentNode";
        List<PatentNodeCountDto> nodeCount =  queryList(sql,null,PatentNodeCountDto.class);
        List<PatentNode> nodeList = Stream.of(PatentNode.values()).sorted(Comparator.comparing(PatentNode::getNode)).collect(Collectors.toList());
        EnumMap<PatentNode, Integer> re = new EnumMap(PatentNode.class);
        nodeList.forEach(n->{re.put(n,0);});
        nodeCount.forEach(node->{
            re.put(node.getPatentNode(),node.getCount());
        });
        return new TResult<>(re);
    }

    @Override
    public PagedResult<PatentListDto> queryPatentPaged(PatentQueryCriteria criteria) {
        if(null == criteria.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        StringBuilder sb =  new StringBuilder("");
        sb.append("select  " +
                " p.agId, " +
                " p.applicationNo, " +
                " p.caseNo, " +
                " p.patentName, " +
                " null recentDueDate, " +
                " p.patentType, " +
                " p.patentNode, " +
                " p.isApplicationSameDay, " +
                " p.applicationSameDayCaseNo, " +
                " p.applicationDate, " +
                " p.authorizationDate, " +
                " p.feeReduceRate, " +
                " p.applicants, " +
                " p.agencyAgents agents, " +
                " p.inventors, " +
                " p.create_datetime , " +
                " pci.contractName, " +
                " pci.contractNo, " +
                " sc.name customerName " +
                " from pat_contract_patent_info p " +
                " left JOIN pat_contract_info pci on pci.id = p.contractId " +
                " LEFT JOIN sys_ag_customer sc on sc.id = p.customerId where p.is_active = 1 and p.agId = '"+criteria.getAgId()+"' ");
        Map<String,Object> param = new HashMap<>();
        if(StringUtils.isNotEmpty(criteria.getApplicationNo())){
            sb.append(" and p.applicationNo like :applicationNo");
            param.put("applicationNo",criteria.getApplicationNo());
        }
        if(StringUtils.isNotEmpty(criteria.getCaseNo())){
            sb.append(" and p.caseNo like :caseNo");
            param.put("caseNo",criteria.getCaseNo());
        }
        if(StringUtils.isNotEmpty(criteria.getPatentName())){
            sb.append(" and p.patentName like :patentName");
            param.put("patentName",criteria.getPatentName());
        }
        //TODO 最近期限日期
        if(StringUtils.isNotEmpty(criteria.getRecentDueTimeStart())){

        }
        if(StringUtils.isNotEmpty(criteria.getRecentDueTimeEnd())){

        }
        if(null != criteria.getPatentType()){
            sb.append(" and p.patentType = :patentType");
            param.put("patentType",criteria.getPatentType());
        }
        if(null != criteria.getPatentNode()){
            sb.append(" and p.patentNode = :patentNode");
            param.put("patentNode",criteria.getPatentNode());
        }
        if(StringUtils.isNotEmpty(criteria.getContractNo())){
            sb.append(" and pci.contractNo like :contractNo");
            param.put("contractNo",criteria.getContractNo());
        }
        if(StringUtils.isNotEmpty(criteria.getCustomerName())){
            sb.append(" and sc.name like :customerName");
            param.put("customerName",criteria.getCustomerName());
        }
        if(StringUtils.isNotEmpty(criteria.getApplicants())){
            sb.append(" and p.applicants like :applicants");
            param.put("applicants",criteria.getApplicants());
        }
        if(StringUtils.isNotEmpty(criteria.getInventors())){
            sb.append(" and p.inventors like :inventors");
            param.put("inventors",criteria.getInventors());
        }
        if(StringUtils.isNotEmpty(criteria.getAgents())){
            sb.append(" and p.agencyAgents like :agents");
            param.put("agents",criteria.getAgents());
        }
        if(StringUtils.isNotEmpty(criteria.getApplicationDateStart())){
            sb.append(" and p.applicationDate >= :applicationDateStart");
            param.put("applicationDateStart",criteria.getApplicationDateStart());
        }
        if(StringUtils.isNotEmpty(criteria.getApplicationDateEnd())){
            sb.append(" and p.applicationDate <= :applicationDateEnd");
            param.put("applicationDateEnd",criteria.getApplicationDateEnd());
        }
        if(StringUtils.isNotEmpty(criteria.getAuthorizationDateStart())){
            sb.append(" and p.authorizationDate >= :authorizationDateStart");
            param.put("authorizationDateStart",criteria.getAgents());
        }
        if(StringUtils.isNotEmpty(criteria.getAuthorizationDateEnd())){
            sb.append(" and p.authorizationDate <= :authorizationDateEnd");
            param.put("authorizationDateEnd",criteria.getAgents());
        }
        //TODO 是否 延时
        if(null != criteria.getIsDelayed()){

        }
        sb.append(" order by p.create_datetime desc");
        return queryPaged(criteria.getPageIndex(),criteria.getPageSize(),sb.toString(),param,PatentListDto.class);
    }

    @Override
    public TResult<PatentDetailDto> getPatentInfoById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        StringBuilder sb = new StringBuilder("");
        sb.append("select " +
                " p.id, " +
                " p.patentName, " +
                " p.patentType, " +
                " p.caseNo, " +
                " p.techDomain, " +
                " p.engineerLeaderId, " +
                " u.realName, " +
                " d.isAdvancePublicity, " +
                " d.isFeeReduce, " +
                " d.isRealTrial, " +
                " d.isReqPriority, " +
                " c.name customerName " +
                " from pat_contract_patent_info p " +
                " LEFT JOIN sys_user u on u.id = p.engineerLeaderId " +
                " LEFT JOIN sys_ag_customer c on c.id = p.customerId " +
                " LEFT JOIN pat_customer_damand d on d.patentId = p.id ");
        sb.append(" where p.id id= '"+id+"'");
        PatentDetailDto detailDto = queryForObject(sb.toString(),null,PatentDetailDto.class);
        //获取申请人信息
        detailDto.setApplicantList(getPatentApplicants(id).getResult());
        //获取发明人信息
        detailDto.setInventorList(getPatentInventors(id).getResult());
        //获取代理人信息
        detailDto.setAgentList(getPatentAgents(id).getResult());
        //获取优先权项
        if(detailDto.getIsReqPriority()){
            detailDto.setPriorityClaimsList(getPatentPriorityClaims(id).getResult());
        }
        return new TResult<>(detailDto);
    }

    @Override
    public TResult<PatentElementDto> getPatentElement(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        SqlBuilder<PatentElementDto> sqlBuilder = HSqlBuilder.hFrom(PatentInfo.class, "p")
                .where("p.id",id)
                .select(PatentElementDto.class);
        PatentElementDto elementDto = queryForObject(sqlBuilder);
        return new TResult<>(elementDto);
    }

    @Override
    public ListResult<PatOfficialFeeDetailDto> getPatentOfficialFeeInfo(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        SqlBuilder<PatOfficialFeeDetailDto> sqlBuilder = HSqlBuilder.hFrom(PatOfficialFeeDetail.class, "p")
                .where("p.patentId",id)
                .select(PatOfficialFeeDetailDto.class);
        return new ListResult<>(queryList(sqlBuilder));
    }

    @Override
    public ListResult<PatApplicantDto> getPatentApplicants(UUID patentId) {
        if(null == patentId){
            throw new IllegalArgumentException("参数patentId不能为null");
        }
        SqlBuilder<PatApplicantDto> applicantSqlBuilder = HSqlBuilder.hFrom(PatApplicant.class, "a")
                .where("a.patentId",patentId)
                .select(PatApplicantDto.class);
        List<PatApplicantDto> applicants = queryList(applicantSqlBuilder);
        return new ListResult<>(applicants);
    }

    @Override
    public ListResult<PatInventorDto> getPatentInventors(UUID patentId) {
        if(null == patentId){
            throw new IllegalArgumentException("参数patentId不能为null");
        }
        SqlBuilder<PatInventorDto> inventorSqlBuilder = HSqlBuilder.hFrom(PatInventor.class, "a")
                .where("a.patentId",patentId)
                .select(PatInventorDto.class);
        List<PatInventorDto> inventors = queryList(inventorSqlBuilder);
        return new ListResult<>(inventors);
    }

    @Override
    public ListResult<PatAgentDto> getPatentAgents(UUID patentId) {
        if(null == patentId){
            throw new IllegalArgumentException("参数patentId不能为null");
        }
        SqlBuilder<PatAgentDto> agentBuilder = HSqlBuilder.hFrom(PatAgent.class, "a")
                .where("a.patentId",patentId)
                .select(PatAgentDto.class);
        List<PatAgentDto> agents = queryList(agentBuilder);
        return new ListResult<>(agents);
    }

    @Override
    public ListResult<PatPriorityClaimsDto> getPatentPriorityClaims(UUID patentId) {
        if(null == patentId){
            throw new IllegalArgumentException("参数patentId不能为null");
        }
        SqlBuilder<PatPriorityClaimsDto> prioritySqlBuilder = HSqlBuilder.hFrom(PatPriorityClaims.class, "a")
                .where("a.patentId",patentId)
                .select(PatPriorityClaimsDto.class);
        List<PatPriorityClaimsDto> claims = queryList(prioritySqlBuilder);
        return new ListResult<>(claims);
    }
}
