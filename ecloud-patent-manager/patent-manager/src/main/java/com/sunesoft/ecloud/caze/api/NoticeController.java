package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.caseclient.dto.DismissedNoticeDto;
import com.sunesoft.ecloud.caze.domain.DismissedNotice;
import com.sunesoft.ecloud.caze.service.NoticeService;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/10/010
 */
@RestController
@RequestMapping(name = "notice")
public class NoticeController {


    @Autowired
    NoticeService noticeService;

    @PostMapping("add")
    public TResult addDismissedNotice(DismissedNoticeDto noticeDto){
        noticeDto.setAgId(UUID.fromString(UserContext.getAgencyId()));
        return noticeService.addDismissedNotice(noticeDto);
    }
}
