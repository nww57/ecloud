package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.LoginResultDto;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.adminclient.dtos.UserPositionDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        return userQueryService.findUserFullById(id);
    }


    /**
     * 查询当前用户基本信息
     * @return
     */
    @GetMapping("")
    public TResult<UserBasicDto> getUserInfo(){
        UUID id = UUID.fromString(UserContext.getUserID());
        return userQueryService.getUserBasicInfoById(id);
    }

//    /**
//     * 新增用户信息
//     * @param userDto
//     * @return
//     */
//    @PostMapping()
//    public TResult addUserInfo (@RequestBody UserDto userDto) {
//        userDto.setAgId(agId);
//        return userService.addOrUpdateUser(userDto);
//    }
//
//    /**
//     * 修改用户信息
//     * @param id
//     * @param userDto
//     * @return
//     */
//    @PutMapping(value = "/{id}")
//    public TResult updateUserInfo (@PathVariable UUID id, @RequestBody UserDto userDto) {
//        userDto.setId(id);
//        return userService.addOrUpdateUser(userDto);
//    }

    /**
     * 修改当前用户信息
     * @param userDto
     * @return
     */
    @PutMapping()
    public TResult updateCurrentUserInfo (@RequestBody UserDto userDto) {
        UUID id = UUID.fromString(UserContext.getUserID());
        userDto.setId(id);
        return userService.updateUserBasicInfo(userDto);
    }

//    /**
//     * 修改密码
//     * @param id
//     * @param oldPw
//     * @param newPw
//     * @return
//     */
//    @PutMapping(value = "/changepw/{id}")
//    public TResult changepw (@PathVariable UUID id, String oldPw, String newPw) {
//        return userService.changePassword(id, oldPw, newPw);
//    }

    /**
     * 修改当前用户密码
     * @param oldPw
     * @param newPw
     * @return
     */
    @PutMapping(value = "/changepw")
    public TResult changepw(String oldPw, String newPw){
        UUID id =UUID.fromString(UserContext.getUserID());
        return userService.changePassword(id,oldPw,newPw);
    }

    @GetMapping(value = "/position/collection")
    public ListResult<UserPositionDto> getPositionList(){
        return userQueryService.getPositionList();
    }

    @RequestMapping(value = "/str", method = RequestMethod.GET)
    public String getString(){
        return "this is a figgen test";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)

    public PagedResult<UserDto> index(){
        Pageable pageable = new PageRequest(0,10,null);
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.setUserName("zhouzh");
        PagedResult<UserDto> userPaged = userQueryService.findUserPaged(userCriteria);
        return userPaged;
    }
}
