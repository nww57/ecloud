package com.sunesoft.ecloud.adminclient.clientService;

import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.ListResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sys-admin")
public interface AuthServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/admin/auth/authfunc/{userId}")
    ListResult<MenuFunctionDto> getFunctions(@PathVariable("userId")String userId);

}