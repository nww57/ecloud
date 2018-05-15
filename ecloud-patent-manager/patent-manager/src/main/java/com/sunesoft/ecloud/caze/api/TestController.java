package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.adminclient.annotation.IgnoreUserToken;
import com.sunesoft.ecloud.adminclient.clientService.CustomerServiceClient;
import com.sunesoft.ecloud.adminclient.clientService.UserServiceClient;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    CustomerServiceClient customerServiceClient;


    @RequestMapping(value = "/getuserinfo")
    public TResult<UserDto> getUserInfo(){
        TResult<UserDto> result = userServiceClient.getUserRealNameAndRoleName(UUID.fromString("94615d65-1417-45e4-8407-1181b44ea457"));
        return result;
    }


    @RequestMapping(value = "/getagent")
    public ListResult<AgentDto> getAgentList(){
        List<UUID> idList = new ArrayList<>();
        idList.add(UUID.fromString("2f0ef79f-3966-47f5-9864-ddf065015ee5"));
        idList.add(UUID.fromString("0bfbad1f-9b76-45d3-b03b-e76de5a549eb"));
        idList.add(UUID.fromString("2e533907-3857-4a46-adb4-c3cdb63bb262"));
        return customerServiceClient.findAgentByIdList(idList);
    }
}

