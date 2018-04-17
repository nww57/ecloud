package com.sunesoft.ecloud.admin.api;


import com.sunesoft.ecloud.admin.api.model.ChangePassword;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/agency/user")
public class AgencyUserController {

    @Autowired
    UserQueryService userQueryService;

    @Autowired
    UserService userService;

    /**
     * 查询员工列表
     * @return
     */
    @GetMapping("search")
    public PagedResult<UserDto> search (UserCriteria userCriteria) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        userCriteria.setAgId(agId);
        return userQueryService.findUserPaged(userCriteria);
    }

    /**
     * 获取用户集合
     * @return
     */
    @GetMapping("collection")
    public ListResult<BasicDto> getList () {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        return userQueryService.getUserConsultantIdName(agId);
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<UserDto> getUserInfo (@PathVariable UUID id) {
        return userQueryService.findUserFullById(id);
    }

    /**
     * 新增用户信息
     * @param userDto
     */
    @PostMapping("")
    public TResult addUserInfo (@RequestBody UserDto userDto) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        userDto.setAgId(agId);
        return userService.addOrUpdateUser(userDto);
    }

    /**
     * 修改用户信息
     * @param userDto
     * @param id
     */
    @PutMapping("{id}")
    public TResult updateUserInfo (@RequestBody UserDto userDto, @PathVariable UUID id) {
        userDto.setId(id);
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        userDto.setAgId(agId);
        return userService.addOrUpdateUser(userDto);
    }

    /**
     * 重置密码
     * @param id
     * @param changePassword
     * @return
     */
    @PutMapping("resetpw/{id}")
    public TResult resetpw (@PathVariable UUID id, @RequestBody ChangePassword changePassword) {
        return userService.setPassword(id, changePassword.getNewPw(),changePassword.getNeed());
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public TResult delete (@RequestParam UUID... ids) {
        return userService.deleteUserBatch(ids);
    }


    @PostMapping("realandrolename")
    public TResult<UserDto> getUserRealNameAndRoleName(){
        return userQueryService.getUserRealNameAndRolName(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
    }

}
