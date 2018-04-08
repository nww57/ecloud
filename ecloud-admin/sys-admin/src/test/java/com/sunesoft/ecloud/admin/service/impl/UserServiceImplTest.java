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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
//        for(int i=1;i<10;i++){
//            UserDto userDto = new UserDto();
//            userDto.setUserName("测试用户删除"+i);
//            userDto.setRealName("43测试"+i);
//            userDto.setCallphone("23231324");
//            userDto.setEmail("1233@qq.com");
//            userDto.setIsWorkon(true);
////            userDto.setOrganizationId(UUID.fromString("7a39654e-db51-4ee6-8366-f07acf0b9fc9"));
//            List<UUID> roleList = new ArrayList<UUID>(){{
//           add(UUID.fromString("3e4c832c-46bc-4601-9808-de55d4aa3d4a"));
//           add(UUID.fromString("e2e16231-d787-4192-a928-94ef8c6c5501"));
//        }};
//            userDto.setRoleIdList(roleList);
//            userService.addOrUpdateUser(userDto);
//        }
        UserDto userDto = new UserDto();
        userDto.setUserName("wanggy3");
        userDto.setRealName("王广杨3");
        userDto.setCallphone("123123");
        userDto.setEmail("1233@qq.com");
        userDto.setIsWorkon(true);
        userDto.setOrganizationId(UUID.fromString("2fc7bc12-f15e-41b0-882c-fe4455723026"));
        List<UUID> roleList = new ArrayList<UUID>(){{
           add(UUID.fromString("840197db-04dd-4961-9bf6-5b8844e10ec5"));
        }};
        userDto.setRoleIdList(roleList);
        userService.addOrUpdateUser(userDto);
        System.out.println(23);
    }

    @Test
    public void deleteUser() throws Exception {
        userService.deleteUser(UUID.fromString("f976099d-cc16-44fc-baaa-20cbf3388b7d"));
        System.out.println(23);
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

    }

    @Test
    public void test2(){

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

    @Test
    public void test5(){

        userRepository.updateOrganizationNull(UUID.fromString("7a39654e-db51-4ee6-8366-f07acf0b9fc9"));
        System.out.println(23);
    }


    @Test
    public void test6(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String s = encoder.encode("888888");
        System.out.println(s);
        BCryptPasswordEncoder encoder1 =new BCryptPasswordEncoder();
        System.out.println(encoder1.matches("888888",s));
    }

}