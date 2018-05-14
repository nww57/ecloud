package com.sunesoft.ecloud.adminclient.clientService;

import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.adminclient.interceptor.FeignConfigInterceptor;
import com.sunesoft.ecloud.common.result.ListResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/14/014
 */
@FeignClient(name = "sys-admin",configuration = FeignConfigInterceptor.class)
public interface CustomerServiceClient {

    @GetMapping(value = "admin/agency/customer/applicantIdList")
    ListResult<CustomerApplicantDto> findCustomerApplicantByIdList(List<UUID> idList);

    @GetMapping(value = "admin/agency/customer/inventorIdList")
    ListResult<CustomerInventorDto> findCustomerInventorByIdList(List<UUID> idList);
}
