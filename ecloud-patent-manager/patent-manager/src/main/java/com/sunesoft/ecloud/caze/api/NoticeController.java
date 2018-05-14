package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.caseclient.dto.DismissedNoticeDto;
import com.sunesoft.ecloud.caze.service.NoticeService;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/10/010
 */
@RestController
@RequestMapping("notice")
public class NoticeController {


    @Autowired
    NoticeService noticeService;

    @GetMapping("/test")
    public  void test(){
        System.out.println(23);
    }

    @PostMapping("add")
    @ResponseBody
    public TResult addDismissedNotice(@RequestBody DismissedNoticeDto noticeDto){
        noticeDto.setAgId(UUID.fromString(UserContext.getAgencyId()));
        return noticeService.addNotice(noticeDto);
    }
}
