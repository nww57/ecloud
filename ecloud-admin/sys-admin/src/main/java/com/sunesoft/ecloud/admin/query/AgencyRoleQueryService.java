package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCretiria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

/**
 * Created by jzj on 2018/3/26.
 */
public interface AgencyRoleQueryService {

    /**
     * 查询角色信息
     * @param pageable
     * @param cretiria
     * @return
     */
    Page<AgencyRoleDto> findAgencyRolePaged(Pageable pageable, AgencyRoleCretiria cretiria);
}
