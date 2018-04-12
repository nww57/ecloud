package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.adminclient.dtos.UserMenuDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserQueryService userQueryService;

    /**
     * 获取用户权限菜单
     * @return
     */
    @GetMapping("menus")
    public ListResult<UserMenuDto> getMenus () {
        return userQueryService.getUserMenuList(UUID.fromString(UserContext.getUserID()));
    }


    /**
     * 获取用户权限菜单
     * @return
     */
    @GetMapping("/authfunc/{userId}")
    public ListResult<MenuFunctionDto> getFunctions (@PathVariable("userId")String userId) {
        return userQueryService.getUserFuncList(UUID.fromString(userId));
    }
}
