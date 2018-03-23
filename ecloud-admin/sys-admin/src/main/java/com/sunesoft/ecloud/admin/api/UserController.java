package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCretiria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Zhouzh
 * @Date: 2018/3/21
 */
@RestController
public class UserController {

    @Autowired
    UserQueryService userQueryService;

    @RequestMapping(value = "/str", method = RequestMethod.GET)
    public String getString(){
        return "this is a figgen test";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)

    public   Page<UserDto> index(){
        Pageable pageable = new PageRequest(0,10,null);
        UserCretiria userCretiria = new UserCretiria();
        userCretiria.setUserName("zhouzh");
        Page<UserDto> userPaged = userQueryService.findUserPaged(pageable, userCretiria);

        return userPaged;
    }
}
