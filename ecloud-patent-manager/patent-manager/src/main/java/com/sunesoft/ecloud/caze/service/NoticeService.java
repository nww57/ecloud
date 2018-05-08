package com.sunesoft.ecloud.caze.service;

import com.sunesoft.ecloud.caseclient.dto.DismissedNoticeDto;
import com.sunesoft.ecloud.common.result.TResult;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 通知书
 */
public interface NoticeService {

    /**
     * 收录未受理的通知书
     * @param dto 参数
     * @return 返回操作结果
     */
    TResult addDismissedNotice(DismissedNoticeDto dto);
}
