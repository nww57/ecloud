package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.DismissedNoticeDto;
import com.sunesoft.ecloud.caze.domain.DismissedNotice;
import com.sunesoft.ecloud.caze.repository.DismissedNoticeRepository;
import com.sunesoft.ecloud.caze.service.NoticeService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    DismissedNoticeRepository dismissedNoticeRepository;

    @Override
    public TResult addDismissedNotice(DismissedNoticeDto dto) {
        if(null == dto.getAgId()){
            throw new IllegalArgumentException("参数agId不能为null");
        }
        DismissedNotice dismissedNotice = new DismissedNotice();
        BeanUtil.copyPropertiesIgnoreNull(dto,dismissedNotice);
        dismissedNoticeRepository.saveAndFlush(dismissedNotice);
        return ResultFactory.success();
    }
}
