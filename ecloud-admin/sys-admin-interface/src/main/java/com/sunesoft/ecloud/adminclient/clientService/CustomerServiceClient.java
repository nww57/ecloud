package com.sunesoft.ecloud.adminclient.clientService;

import com.sunesoft.ecloud.adminclient.annotation.IgnoreUserToken;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.adminclient.interceptor.FeignConfigInterceptor;
import com.sunesoft.ecloud.common.result.ListResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/14/014
 */
@FeignClient(name = "sys-admin",url = "localhost:5010",configuration = FeignConfigInterceptor.class)
public interface CustomerServiceClient {


    @PostMapping(value = "admin/agency/agent/idList")
    ListResult<AgentDto> findAgentByIdList(@RequestParam("idList") List<UUID> idList);

    @IgnoreUserToken
    @PostMapping(value = "admin/agency/customer/applicantIdList")
    ListResult<CustomerApplicantDto> findCustomerApplicantByIdList(@RequestParam("idList") List<UUID> idList);

    @IgnoreUserToken
    @PostMapping(value = "admin/agency/customer/inventorIdList")
    ListResult<CustomerInventorDto> findCustomerInventorByIdList(@RequestParam("idList") List<UUID> idList);
}
