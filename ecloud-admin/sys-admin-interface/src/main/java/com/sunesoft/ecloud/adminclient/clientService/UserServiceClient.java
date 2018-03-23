package com.sunesoft.ecloud.adminclient.clientService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sys-admin")
public interface UserServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/sysadmin/str", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getString();

}