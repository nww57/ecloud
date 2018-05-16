package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.DismissedNoticeDto;
import com.sunesoft.ecloud.caze.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/5/8/008
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticeServiceImplTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void addDismissedNotice() throws Exception {
        DismissedNoticeDto dto = new DismissedNoticeDto();
        dto.setNoticeCode("asdf12345");
        dto.setNoticeName("未受理通知书1");
        dto.setCaseNo("aj13234");
        dto.setPatentName("测试");
        dto.setSendFileDate(LocalDate.now());
        dto.setApplicationDate(LocalDate.now());
        dto.setApplicationNo("adsf");
        noticeService.addNotice(dto);
    }

    @Test
    public void test(){
        noticeService.testContentToBean();
    }


    @Test
    public void handleNotice(){
        noticeService.handleNotice(UUID.fromString("001cbb37-f81e-429a-aa17-a2b3ec96ff48"));
    }

}