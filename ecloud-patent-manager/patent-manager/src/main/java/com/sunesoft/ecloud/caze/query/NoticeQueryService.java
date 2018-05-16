package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.criterias.NoticeQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.notice.NoticeListInfoDto;
import com.sunesoft.ecloud.common.result.PagedResult;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public interface NoticeQueryService {

    /**
     * 查询通知书列表
     * @param criteria 查询参数
     * @return 返回崔查询给结果
     */
    PagedResult<NoticeListInfoDto> queryNoticeByPaged(NoticeQueryCriteria criteria);
}
