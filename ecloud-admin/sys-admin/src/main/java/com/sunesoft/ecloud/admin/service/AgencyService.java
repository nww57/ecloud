package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public interface AgencyService {

    TResult addOrUpdateAgency(AgencyDto agencyDto);

    TResult delete(UUID id);




}
