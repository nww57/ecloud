package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCretiria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Pageable;

/**
 * Created by jzj on 2018/3/26.
 * 机构查询
 */
public interface AgencyOrganizationQueryServicce {

    TResult<AgencyOrganizationDto> findAgencyOrganizationPaged(Pageable pageable, AgencyOrganizationCretiria cretiria);
}