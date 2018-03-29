package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserQueryService userQueryService;

    @Autowired
    UserService userService;

    /**
     * 用户基本信息
     * @return
     */
    @GetMapping("/{id}")
    public TResult<UserDto> getUserInfo (@PathVariable UUID id) {
        return userQueryService.findUserBasicById(id);
    }

    /**
     * 新增用户信息
     * @param userDto
     * @return
     */
    @PostMapping()
    public TResult addUserInfo (@RequestBody UserDto userDto) {
        return userService.addOrUpdateUser(userDto);
    }

    /**
     * 修改用户信息
     * @param id
     * @param userDto
     * @return
     */
    @PutMapping(value = "/{id}")
    public TResult updateUserInfo (@PathVariable UUID id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        return userService.addOrUpdateUser(userDto);
    }

    /**
     * 修改密码
     * @param id
     * @param oldPw
     * @param newPw
     * @return
     */
    @PutMapping(value = "/changepw/{id}")
    public TResult changepw (@PathVariable UUID id, String oldPw, String newPw) {
        return userService.changePassword(id, oldPw, newPw);
    }


    @RequestMapping(value = "/str", method = RequestMethod.GET)
    public String getString(){
        return "this is a figgen test";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)

    public   Page<UserDto> index(){
        Pageable pageable = new PageRequest(0,10,null);
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.setUserName("zhouzh");
        Page<UserDto> userPaged = userQueryService.findUserPaged(userCriteria);

        return userPaged;
    }
}
