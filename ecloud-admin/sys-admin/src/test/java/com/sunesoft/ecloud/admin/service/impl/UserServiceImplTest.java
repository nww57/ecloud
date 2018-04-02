package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.repository.AgencyAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.UserPositionType;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    AgencyAuthorizedMenuRepository agMenuRepository;

    @Test
    public void addOrUpdateUser() throws Exception {
//        for(int i=5;i<19;i++){
//            UserDto userDto = new UserDto();
//            userDto.setUserName("wangwu"+i);
//            userDto.setRealName("王五"+i);
//            userDto.setCallphone("23231324");
//            userDto.setEmail("1233@qq.com");
//            userDto.setWorkon(true);
//            userDto.setOrganizationId(UUID.fromString("8375a551-8759-4bc4-9e3c-59fd12d8ebb4"));
//            userService.addOrUpdateUser(userDto);
//        }
        UserDto userDto = new UserDto();
        userDto.setUserName("wangwu");
        userDto.setRealName("王五");
        userDto.setCallphone("23231324");
        userDto.setEmail("1233@qq.com");
        userDto.setIsWorkon(true);
//        userDto.setOrganizationId(UUID.fromString("f5c3aaa2-24aa-4479-9bc6-d3af988c604a"));
//        List<UUID> roleList = new ArrayList<UUID>(){{
//           add(UUID.fromString("4d246b07-0fff-41bc-9f20-13e08488a592"));
//        }};
//        userDto.setRoleIdList(roleList);
        userService.addOrUpdateUser(userDto);
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
        TResult result = userService.changePassword(UUID.fromString("42c569c0-7be3-42c6-9c07-6d9939d2739d"),"123","456");
        System.out.println(23);
    }

    @Test
    public void setPassword() throws Exception {
        userService.setPassword(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"),"1asdfasf");
        System.out.println(23);
    }

    @Test
    public void test2(){
        userRepository.updatePassword(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"),"23asdfa");
        System.out.println(23);
    }

    @Test
    public void test3(){
        List<String> list = agMenuRepository.getMenuId("d2d512f3-0a6c-4373-9ab2-a348fb616d7a");
        System.out.println(23);
    }


    @Test
    public void test4(){
        userRepository.updatePosition(UUID.fromString("42c569c0-7be3-42c6-9c07-6d9939d2739d"), UserPositionType.LEADER.getCode());
        System.out.println(23);
    }

    @Test
    public void updateUserBasicInfo(){
        UserBasicDto dto = new UserBasicDto();
        dto.setRealName("来看看的");
        dto.setEmail("555@qq.com");
        TResult result = userService.updateUserBasicInfo(dto);
        System.out.println(23);
    }

}