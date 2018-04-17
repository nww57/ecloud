package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.adminclient.clientService.UserServiceClient;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caze.query.CaseQueryService;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/16/016
 */
@RestController
@RequestMapping("/case")
public class CaseController {

    @Autowired
    CaseQueryService queryService;

    @Autowired
    UserServiceClient userServiceClient;

    @GetMapping("/search")
    public PagedResult<CaseInfoListDto> queryCaseList(){
        CaseInfoQueryCriteria criteria  = new CaseInfoQueryCriteria();
        criteria.setAgId(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"));
        return queryService.queryCaseInfoByPaged(criteria);
    }

    @GetMapping("/userinfo")
    public TResult<UserDto> getUserInfo(){
     return  userServiceClient.getUserRealNameAndRoleName();
    }
}
