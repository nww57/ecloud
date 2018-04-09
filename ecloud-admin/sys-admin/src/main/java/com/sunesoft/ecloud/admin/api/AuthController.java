package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserService userService;

    /**
     * 获取授权码
     * @param username
     * @param password
     * @return
     */
    @PostMapping("token")
    public TResult getToken (String username, String password) {
        return userService.userLogin(username, password);
    }

    /**
     * 删除授权码
     */
    @DeleteMapping("token")
    public void deleteToken () {

    }
}
