package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caze.domain.CaseCustomerRequest;
import com.sunesoft.ecloud.caze.domain.CaseInfo;
import com.sunesoft.ecloud.caze.domain.CaseMessage;
import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.caze.query.CaseQueryService;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@Service
public class CaseQueryServiceImpl extends GenericQuery implements CaseQueryService {

    @Override
    public PagedResult<CaseInfoListDto> queryCaseInfoByPaged(CaseInfoQueryCriteria criteria) {
        if(null == criteria.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        StringBuilder sql = new StringBuilder("SELECT " +
                " ci.id,  " +
                " ci.caseNo,  " +
                " ci.caseName,  " +
                " ci.caseType,  " +
                " ci.creatorName,  " +
                " ci.feeReduceRate,  " +
                " ci.create_datetime caseCreateDate,  " +
                " ci.comments,  " +
                " ac. NAME customerName,  " +
                " ac.leader customerLeader,  " +
                " ac.leaderMobile customerLeaderMobile,  " +
                " u.realName customerConsultantName,  " +
                " GROUP_CONCAT(p.id) patentId,  " +
                " GROUP_CONCAT(p.patentName) patentName,  " +
                " GROUP_CONCAT(p.patentNo) patentNo,  " +
                " GROUP_CONCAT(p.patentType) patentType " +
                " FROM " +
                " case_info ci  " +
                " LEFT JOIN sys_ag_customer ac ON ci.customerId = ac.id  " +
                " LEFT JOIN sys_user u ON u.id = ac.consultantId  " +
                " LEFT JOIN patent_info p ON p.caseId = ci.id  where 1=1 and ci.agId = '" +criteria.getAgId() +"' ");
        //TODO 参数设置
        sql.append(" group by ci.id");
        PagedResult<CasePatentInfoDto> infoList = queryPaged(criteria.getPageIndex(),criteria.getPageSize(),sql.toString(),new HashMap<>(),CasePatentInfoDto.class);
        List<CaseInfoListDto> dtoList = new ArrayList<>();
        infoList.getResult().forEach(info->{
            dtoList.add(transform(info));
        });
        return new PagedResult<>(dtoList, infoList.getPageIndex(),infoList.getPageSize(), infoList.getTotalCount());
    }


    @Override
    public TResult<CaseInfoListDto> queryCaseBasicInfoById(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("参数id不能为null");
        }
        String sql = "SELECT " +
                " ci.id,  " +
                " ci.caseNo,  " +
                " ci.caseName,  " +
                " ci.caseType,  " +
                " ci.creatorName,  " +
                " ci.feeReduceRate,  " +
                " ci.create_datetime caseCreateDate,  " +
                " ci.comments,  " +
                " ac. NAME customerName,  " +
                " ac.leader customerLeader,  " +
                " ac.leaderMobile customerLeaderMobile,  " +
                " u.realName customerConsultantName,  " +
                " GROUP_CONCAT(p.id) patentId,  " +
                " GROUP_CONCAT(p.patentName) patentName,  " +
                " GROUP_CONCAT(p.patentNo) patentNo,  " +
                " GROUP_CONCAT(p.patentType) patentType " +
                " FROM " +
                " case_info ci  " +
                " LEFT JOIN sys_ag_customer ac ON ci.customerId = ac.id  " +
                " LEFT JOIN sys_user u ON u.id = ac.consultantId  " +
                " LEFT JOIN patent_info p ON p.caseId = ci.id  where 1=1 and ci.id = "+id;
        CasePatentInfoDto info = queryForObject(sql,null,CasePatentInfoDto.class);
        return new TResult<>(transform(info));
    }

    @Override
    public PagedResult<CaseCustomerRequestDto> queryCaseCustomerRequestByPaged(UUID id, TCretiria criteria) {
        SqlBuilder<CaseCustomerRequestDto> sqlBuilder = HSqlBuilder.hFrom(CaseCustomerRequest.class, "r")
                .where("r.caseId",id)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(CaseCustomerRequestDto.class);
        return queryPaged(sqlBuilder);
    }

    @Override
    public PagedResult<CaseMessageListDto> queryCaseMessageByPaged(UUID id, TCretiria criteria) {
        SqlBuilder<CaseMessageListDto> sqlBuilder = HSqlBuilder.hFrom(CaseMessage.class, "c")
                .where("c.caseId",id)
                .pagging(criteria.getPageIndex(),criteria.getPageSize())
                .select(CaseMessageListDto.class)
                .setFieldValue("messageDate","c.create_datetime");
        return queryPaged(sqlBuilder);

    }

    private CaseInfoListDto transform(CasePatentInfoDto info) {
        CaseInfoListDto dto = new CaseInfoListDto();
        BeanUtil.copyPropertiesIgnoreNull(info,dto);
        String[] patentId = info.getPatentId().split(",");
        String[] patentNo = null==info.getPatentNo()?null:info.getPatentNo().split(",");
        String[] patentName = info.getPatentName().split(",");
        String[] patentType = info.getPatentType().split(",");
        List<PatentBasicDto> patentBasicDtoList = new ArrayList<>();
        PatentBasicDto patentDto ;
        for(int i=0;i<patentId.length;i++){
            patentDto = new PatentBasicDto();
            patentDto.setId(UUID.fromString(patentId[i]));
            patentDto.setPatentNo(patentName[i]);
            if(null != patentNo){
                patentDto.setPatentNo(patentNo[i]);
            }
            patentDto.setPatentType(PatentType.valueOf(patentType[i]));
            patentBasicDtoList.add(patentDto);
        }
        dto.setPatentBasicList(patentBasicDtoList);
        return dto;
    }
}
