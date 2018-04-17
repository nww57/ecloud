package com.sunesoft.ecloud.adminclient.clientService;

import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sys-admin",url = "localhost:5010")
public interface AuthServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/admin/auth/authfunc/{userId}")
    ListResult<MenuFunctionDto> getFunctions(@PathVariable("userId")String userId);

    @RequestMapping(method = RequestMethod.GET, value = "/admin/agency/user/realandrolename")
    TResult<UserDto> getUserRealNameAndRoleName();

}