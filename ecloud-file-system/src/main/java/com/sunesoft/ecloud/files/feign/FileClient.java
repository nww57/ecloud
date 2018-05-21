package com.sunesoft.ecloud.files.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @auther: niww
 * @date: 2018/5/21/021
 */
@FeignClient(name = "sys-file",url = "192.168.1.115")
public interface FileClient {

    @PostMapping(value = "/toXML")
    public void packaging(@RequestParam("agId") String agId, @RequestParam("patentId")String patentId,@RequestParam("objectMap") Map<String,Object> objectMap);
}
