package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.NoticeQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.notice.NoticeListInfoDto;
import com.sunesoft.ecloud.caze.query.NoticeQueryService;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
@Service
public class NoticeQueryServiceImpl extends GenericQuery implements NoticeQueryService {


    @Override
    public PagedResult<NoticeListInfoDto> queryNoticeByPaged(NoticeQueryCriteria criteria) {
        UUID agId = criteria.getAgId();
        if (null == agId) {
            throw new IllegalArgumentException("参数agId不能为null");
        }
        StringBuilder sql = new StringBuilder("");
        sql.append("select " +
                " n.agId," +
                " n.id," +
                " n.caseNo," +
                " n.applicationNo," +
                " n.patentName," +
                " n.noticeCode," +
                " n.noticeName," +
                " n.applicationDate," +
                " n.sendFileDate, " +
                " c.name customerName " +
                " from pat_notice_info n " +
                " LEFT JOIN pat_contract_patent_info p on p.caseNo = n.caseNo and p.agId = n.agId " +
                " LEFT JOIN sys_ag_customer c on p.customerId = c.id " +
                " where n.handleStatus = 0 and n.agId = '" + agId + "'");
        Map<String, Object> param = new HashMap<>();
        return queryPaged(criteria.getPageIndex(), criteria.getPageSize(), sql.toString(), param, NoticeListInfoDto.class);
    }
}
