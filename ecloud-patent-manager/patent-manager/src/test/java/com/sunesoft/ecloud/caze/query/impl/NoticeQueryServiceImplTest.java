package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.NoticeQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.notice.NoticeListInfoDto;
import com.sunesoft.ecloud.caze.query.NoticeQueryService;
import com.sunesoft.ecloud.common.result.PagedResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticeQueryServiceImplTest {
    @Autowired
    NoticeQueryService noticeQueryService;

    @Test
    public void queryNoticeByPaged() {
        NoticeQueryCriteria criteria = new NoticeQueryCriteria();
        criteria.setAgId(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"));
        PagedResult<NoticeListInfoDto> result = noticeQueryService.queryNoticeByPaged(criteria);
        System.out.println(12);
    }
}