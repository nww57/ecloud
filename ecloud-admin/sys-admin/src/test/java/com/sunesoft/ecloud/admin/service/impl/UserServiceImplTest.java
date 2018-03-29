package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Test
    public void addOrUpdateUser() throws Exception {
        for(int i=5;i<19;i++){
            UserDto userDto = new UserDto();
            userDto.setUserName("wangwu"+i);
            userDto.setRealName("王五"+i);
            userDto.setCallphone("23231324");
            userDto.setEmail("1233@qq.com");
            userDto.setWorkon(true);
            userDto.setOrganizationId(UUID.fromString("8375a551-8759-4bc4-9e3c-59fd12d8ebb4"));
            userService.addOrUpdateUser(userDto);
        }
//        UserDto userDto = new UserDto();
//        userDto.setUserName("wangwu");
//        userDto.setRealName("王五");
//        userDto.setCallphone("23231324");
//        userDto.setEmail("1233@qq.com");
//        userDto.setWorkon(true);
//        userDto.setOrganizationId(UUID.fromString("f5c3aaa2-24aa-4479-9bc6-d3af988c604a"));
//        List<UUID> roleList = new ArrayList<UUID>(){{
//           add(UUID.fromString("cc814000-195a-4bd4-802d-acfea9fda8b1"));
//        }};
//        userDto.setRoleIdList(roleList);
//        userService.addOrUpdateUser(userDto);
        System.out.println(23);
    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void deleteUserBatch() throws Exception {
    }

    @Test
    public void changePassword() throws Exception {
    }

    @Test
    public void setPassword() throws Exception {
    }

}