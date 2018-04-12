package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyOrganizationQueryService;
import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/agency/org")
public class AgencyOrgController {

    @Autowired
    AgencyOrganizationQueryService organizationQueryServicce;

    @Autowired
    AgencyOrganizationService organizationService;

    /**
     * 组织架构列表获取
     * @param criteria
     *
     * @return
     */
    @GetMapping("search")
    public ListResult<AgencyOrganizationDto> search (AgencyOrganizationCriteria criteria) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        criteria.setAgId(agId);
        return organizationQueryServicce.findAgencyOrganization(criteria);
    }

    /**
     * 获取组织列表
     * @return
     */
    @GetMapping("collection")
    public ListResult<BasicDto> collection () {
        return organizationQueryServicce.getOrganizationIdName();
    }

    /**
     * 获取组织机构详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<AgencyOrganizationDto> getInfo (@PathVariable UUID id) {
        return organizationQueryServicce.findAgencyOrganizationBasicById(id);
    }

    /**
     * 新增组织机构
     * @param agencyOrganizationDto
     * @return
     */
    @PostMapping("")
    public TResult addInfo (@RequestBody AgencyOrganizationDto agencyOrganizationDto) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyOrganizationDto.setAgId(agId);
        return organizationService.addOrUpdateOrganization(agencyOrganizationDto);
    }

    /**
     * 修改组织机构
     * @param id
     * @param agencyOrganizationDto
     * @return
     */
    @PutMapping("{id}")
    public TResult updateInfo (@PathVariable UUID id, @RequestBody AgencyOrganizationDto agencyOrganizationDto) {
        agencyOrganizationDto.setId(id);
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyOrganizationDto.setAgId(agId);
        return organizationService.addOrUpdateOrganization(agencyOrganizationDto);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public TResult batchDel (@RequestParam UUID... ids) {
        return organizationService.deleteBatch(ids);
    }

}
