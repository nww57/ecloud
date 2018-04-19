package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caze.domain.*;
import com.sunesoft.ecloud.caze.query.CaseQueryService;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.OrderType;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.*;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@Service
public class CaseQueryServiceImpl extends GenericQuery implements CaseQueryService {

    @Override
    public PagedResult<CaseInfoListDto> queryCaseInfoByPaged(CaseInfoQueryCriteria criteria) {
        if (null == criteria.getAgId()) {
            throw new IllegalArgumentException("企业id不能为null");
        }
        StringBuilder sql = new StringBuilder("SELECT " +
                " ci.id,  " +
                " ci.caseNo,  " +
                " ci.caseName,  " +
                " ci.caseType,  " +
                " ci.caseCreatorName,  " +
                " ci.feeReduceRate,  " +
                " ci.create_datetime caseCreateDate,  " +
                " ci.comments,  " +
                " ac.NAME customerName,  " +
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
                " LEFT JOIN patent_info p ON p.caseId = ci.id  where ci.is_active = 1 and ci.agId = '" + criteria.getAgId() + "' ");
        // 参数设置
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotEmpty(criteria.getCaseNo())) {
            sql.append(" and ci.caseNo like :caseNo");
            params.put("caseNo", "%" + criteria.getCaseNo() + "%");
        }
        if (StringUtils.isNotEmpty(criteria.getCaseName())) {
            sql.append(" and ci.caseName like :caseName");
            params.put("caseName", "%" + criteria.getCaseName() + "%");
        }
        if (StringUtils.isNotEmpty(criteria.getCustomerName())) {
            sql.append(" and ac.NAME like :customerName");
            params.put("customerName", "%" + criteria.getCustomerName() + "%");
        }
        if (StringUtils.isNotEmpty(criteria.getCaseCreatorName())) {
            sql.append(" and ci.creatorName like :creatorName");
            params.put("creatorName", "%" + criteria.getCaseCreatorName() + "%");
        }
        if (StringUtils.isNotEmpty(criteria.getConsultantName())) {
            sql.append(" and u.realName like :consultantName");
            params.put("consultantName", "%" + criteria.getConsultantName() + "%");
        }
        if (StringUtils.isNotEmpty(criteria.getCaseCreateDateStart())) {
            sql.append(" and ci.create_datetime >= :caseCreateDateStart");
            params.put("caseCreateDateStart", criteria.getCaseCreateDateStart());
        }
        if (StringUtils.isNotEmpty(criteria.getCaseCreateDateEnd())) {
            sql.append(" and ci.create_datetime <= :caseCreateDateEnd");
            params.put("caseCreateDateEnd", criteria.getCaseCreateDateEnd());
        }
        if (null != criteria.getFeeReduceRate()) {
            sql.append(" and ci.feeReduceRate = :feeReduceRate");
            params.put("feeReduceRate", criteria.getFeeReduceRate());
        }
        if (StringUtils.isNotEmpty(criteria.getPatentNo())) {
            sql.append(" and patentNo like :patentNo");
            params.put("patentNo", "%" + criteria.getPatentNo() + "%");
        }
        if (null != criteria.getPatentType()) {
            sql.append(" and patentType like :patentType");
            params.put("patentType", "%" + criteria.getPatentType().name() + "%");
        }
        sql.append(" group by ci.id order by ci.create_datetime desc");
        PagedResult<CasePatentInfoDto> infoList = queryPaged(criteria.getPageIndex(), criteria.getPageSize(), sql.toString(), params, CasePatentInfoDto.class);
        List<CaseInfoListDto> dtoList = new ArrayList<>();
        infoList.getResult().forEach(info -> {
            dtoList.add(transform(info));
        });
        return new PagedResult<>(dtoList, infoList.getPageIndex(), infoList.getPageSize(), infoList.getTotalCount());
    }


    @Override
    public TResult<CaseInfoListDto> queryCaseBasicInfoById(UUID id) {
        if (null == id) {
            throw new IllegalArgumentException("参数id不能为null");
        }
        String sql = "SELECT " +
                " ci.id,  " +
                " ci.caseNo,  " +
                " ci.caseName,  " +
                " ci.caseType,  " +
                " ci.caseCreatorName,  " +
                " ci.feeReduceRate,  " +
                " ci.create_datetime caseCreateDate,  " +
                " ci.comments,  " +
                " ac.id customerId , "+
                " ac.NAME customerName,  " +
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
                " LEFT JOIN patent_info p ON p.caseId = ci.id  where 1=1 and ci.id = '" + id+"'";
        CasePatentInfoDto info = queryForObject(sql, null, CasePatentInfoDto.class);
        return new TResult<>(transform(info));
    }

    @Override
    public PagedResult<CaseCustomerRequestDto> queryCaseCustomerRequestByPaged(UUID id, TCretiria criteria) {
        if (null == id) {
            throw new IllegalArgumentException("案件id不能为null");
        }
        SqlBuilder<CaseCustomerRequestDto> sqlBuilder = HSqlBuilder.hFrom(CaseCustomerRequest.class, "r")
                .where("r.caseId", id)
                .pagging(criteria.getPageIndex(), criteria.getPageSize())
                .orderBy("create_datetime", OrderType.DESC)
                .select(CaseCustomerRequestDto.class);
        return queryPaged(sqlBuilder);
    }

    @Override
    public PagedResult<CaseMessageListDto> queryCaseMessageByPaged(UUID id, TCretiria criteria) {
        if (null == id) {
            throw new IllegalArgumentException("案件id不能为null");
        }
        String sql = "select DATE_FORMAT(m.create_datetime, '%Y-%c-%d %h:%i:%s') messageDate,m.content,m.messagerId,u.realName messagerRealName,GROUP_CONCAT(r.name) messagerRoleName  from case_message m LEFT JOIN sys_user u on m.messagerId = u.id " +
                " LEFT JOIN sys_ag_user_role ur on ur.userId = u.id " +
                " LEFT JOIN sys_ag_role r on ur.roleId = r.id where m.caseId = '"+id+"' "+
                " GROUP BY m.id,u.id order by m.create_datetime desc";
        return queryPaged(criteria.getPageIndex(),criteria.getPageSize(),sql,null,CaseMessageListDto.class);
//        SqlBuilder<CaseMessageListDto> sqlBuilder = HSqlBuilder.hFrom(CaseMessage.class, "c")
//                .where("c.caseId", id)
//                .pagging(criteria.getPageIndex(), criteria.getPageSize())
//                .select(CaseMessageListDto.class)
//                .setFieldValue("messageDate", "c.create_datetime");
//        return queryPaged(sqlBuilder);
    }

    @Override
    public TResult<CaseInfoColumnConfigureDto> queryUserCaseInfoColumnConfigure(UUID userId) {
        if(null == userId){
            throw new IllegalArgumentException("用户id不能为null");
        }
        SqlBuilder<CaseInfoColumnConfigureDto> sqlBuilder = HSqlBuilder.hFrom(CaseInfoColumnConfigure.class, "c")
                .where("userId", userId)
                .select(CaseInfoColumnConfigureDto.class);
        return new TResult<>(queryForObject(sqlBuilder));
    }

    private CaseInfoListDto transform(CasePatentInfoDto info) {
        CaseInfoListDto dto = new CaseInfoListDto();
        BeanUtil.copyPropertiesIgnoreNull(info, dto);
        String[] patentId = info.getPatentId().split(",");
        String[] patentNo = null == info.getPatentNo() ? null : info.getPatentNo().split(",");
        String[] patentName = info.getPatentName().split(",");
        String[] patentType = info.getPatentType().split(",");
        List<PatentBasicDto> patentBasicDtoList = new ArrayList<>();
        PatentBasicDto patentDto;
        for (int i = 0; i < patentId.length; i++) {
            patentDto = new PatentBasicDto();
            patentDto.setId(UUID.fromString(patentId[i]));
            patentDto.setPatentNo(patentName[i]);
            if (null != patentNo) {
                patentDto.setPatentNo(patentNo[i]);
            }
            patentDto.setPatentType(PatentType.valueOf(patentType[i]));
            patentBasicDtoList.add(patentDto);
        }
        dto.setPatentBasicList(patentBasicDtoList);
        return dto;
    }
}
