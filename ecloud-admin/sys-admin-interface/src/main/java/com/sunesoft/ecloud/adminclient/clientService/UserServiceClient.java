package com.sunesoft.ecloud.adminclient.clientService;

import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.adminclient.interceptor.FeignConfigInterceptor;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sys-admin",url = "localhost:5010",configuration = FeignConfigInterceptor.class)
public interface UserServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/admin/agency/user/realandrolename")
    TResult<UserDto> getUserRealNameAndRoleName();
}