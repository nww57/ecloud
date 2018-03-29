package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("agency/role")
public class AgencyRoleController {

    @Autowired
    AgencyRoleQueryService agencyRoleQueryService;

    @Autowired
    AgencyRoleService agencyRoleService;

    /**
     * 查询角色
     * @param agencyRoleCriteria
     * @return
     */
    @GetMapping("search")
    @ResponseBody
    public Page<AgencyRoleDto> search (@RequestBody AgencyRoleCriteria agencyRoleCriteria) {
       return agencyRoleQueryService.findAgencyRolePaged(agencyRoleCriteria);
    }

    /**
     * 获取角色信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public TResult<AgencyRoleDto> getInfo (@PathVariable UUID id) {
        return agencyRoleQueryService.getAgencyRoleBasicById(id);
    }

    /**
     * 新增角色信息
     * @param agencyRoleDto
     * @return
     */
    @PostMapping("")
    @ResponseBody
    public TResult addInfo (@RequestBody AgencyRoleDto agencyRoleDto) {
        return agencyRoleService.addOrUpdateRole(agencyRoleDto);
    }

    /**
     * 修改角色
     * @param id
     * @param agencyRoleDto
     * @return
     */
    @PutMapping("{id}")
    @ResponseBody
    public TResult updateInfo (@PathVariable UUID id, @RequestBody AgencyRoleDto agencyRoleDto) {
        agencyRoleDto.setId(id);
        return agencyRoleService.addOrUpdateRole(agencyRoleDto);
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    @DeleteMapping()
    @ResponseBody
    public TResult deleteInfo (@RequestParam UUID... ids) {
        return agencyRoleService.deleteBatch(ids);
    }

    /**
     * 获取角色列表
     */
    @GetMapping("collection")
    @ResponseBody
    public ListResult<BasicDto> getCollection () {
        return agencyRoleQueryService.getAgencyRoleIdName();
    }
}
