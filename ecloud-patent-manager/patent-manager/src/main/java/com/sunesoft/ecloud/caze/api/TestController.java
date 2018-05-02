package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.adminclient.clientService.UserServiceClient;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/18/018
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    UserServiceClient userServiceClient;

    @RequestMapping(value = "/getuserinfo")
    public TResult<UserDto> getUserInfo(){
        TResult<UserDto> result = userServiceClient.getUserRealNameAndRoleName(UUID.fromString("94615d65-1417-45e4-8407-1181b44ea457"));
        return result;
    }
}

