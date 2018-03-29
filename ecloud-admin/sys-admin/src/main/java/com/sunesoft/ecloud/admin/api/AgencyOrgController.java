package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyOrganizationQueryServicce;
import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/agency/org")
public class AgencyOrgController {

    @Autowired
    AgencyOrganizationQueryServicce organizationQueryServicce;

    @Autowired
    AgencyOrganizationService organizationService;

    /**
     * 组织架构列表获取
     * @param criteria
     * @return
     */
    @GetMapping("search")
    @ResponseBody
    public ListResult<AgencyOrganizationDto> search (@RequestParam AgencyOrganizationCriteria criteria) {
        return organizationQueryServicce.findAgencyOrganization(criteria);
    }

    /**
     * 获取组织机构详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public TResult<AgencyOrganizationDto> getInfo (@PathVariable UUID id) {
        return organizationQueryServicce.findAgencyOrganizationBasicById(id);
    }

    /**
     * 新增组织机构
     * @param agencyOrganizationDto
     * @return
     */
    @PostMapping()
    @ResponseBody
    public TResult addInfo (@RequestBody AgencyOrganizationDto agencyOrganizationDto) {
        return organizationService.addOrUpdateOrganization(agencyOrganizationDto);
    }

    /**
     * 修改组织机构
     * @param id
     * @param agencyOrganizationDto
     * @return
     */
    @PutMapping("{id}")
    @ResponseBody
    public TResult updateInfo (@PathVariable UUID id, @RequestBody AgencyOrganizationDto agencyOrganizationDto) {
        agencyOrganizationDto.setId(id);
        return organizationService.addOrUpdateOrganization(agencyOrganizationDto);
    }

}
