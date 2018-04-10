package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;
import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("agency/role")
public class AgencyRoleController {

    @Autowired
    AgencyRoleQueryService agencyRoleQueryService;

    @Autowired
    AgencyRoleService agencyRoleService;

    @Autowired
    MenuQueryService menuQueryService;

    /**
     * 查询角色
     * @param agencyRoleCriteria
     * @return
     */
    @GetMapping("search")
    public Page<AgencyRoleDto> search (AgencyRoleCriteria agencyRoleCriteria) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyRoleCriteria.setAgId(agId);
       return agencyRoleQueryService.findAgencyRolePaged(agencyRoleCriteria);
    }

    /**
     * 获取角色列表
     * @return
     */
    @GetMapping("collection")
    public ListResult<BasicDto> collection () {
        return agencyRoleQueryService.getAgencyRoleIdName();
    }

    /**
     * 获取角色信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<AgencyRoleDto> getInfo (@PathVariable UUID id) {
        return agencyRoleQueryService.getAgencyRoleBasicById(id);
    }

    /**
     * 新增角色信息
     * @param agencyRoleDto
     * @return
     */
    @PostMapping("")
    public TResult addInfo (@RequestBody AgencyRoleDto agencyRoleDto) {
        agencyRoleDto.setAgId(UUID.fromString(UserContext.getAgencyId()));
        return agencyRoleService.addOrUpdateRole(agencyRoleDto);
    }

    /**
     * 修改角色
     * @param id
     * @param agencyRoleDto
     * @return
     */
    @PutMapping("{id}")
    public TResult updateInfo (@PathVariable UUID id, @RequestBody AgencyRoleDto agencyRoleDto) {
        agencyRoleDto.setId(id);
        agencyRoleDto.setAgId(UUID.fromString(UserContext.getAgencyId()));
        return agencyRoleService.addOrUpdateRole(agencyRoleDto);
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    @DeleteMapping()
    public TResult deleteInfo (@RequestParam UUID... ids) {
        return agencyRoleService.deleteBatch(ids);
    }

    /**
     * 获取角色列表
     */
    @GetMapping("menus")
    public ListResult<MenuDto> getMenus () {
        return menuQueryService.findAgAllMenu();
    }
}
