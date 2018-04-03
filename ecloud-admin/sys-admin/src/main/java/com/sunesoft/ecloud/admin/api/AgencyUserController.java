package com.sunesoft.ecloud.admin.api;


import com.sunesoft.ecloud.admin.api.model.ChangePassword;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<UserDto> search (UserCriteria userCriteria) {
        return userQueryService.findUserPaged(userCriteria);
    }

    /**
     * 获取用户集合
     * @return
     */
    @GetMapping("collection")
    public ListResult<BasicDto> getList () {
        return userQueryService.getUserIdName();
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

}
