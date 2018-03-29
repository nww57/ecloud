package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleMenuDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.java2d.pipe.SpanIterator;

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
public class AgencyRoleServiceImplTest {

    @Autowired
    AgencyRoleService roleService;

    @Test
    public void addOrUpdateRole() throws Exception {
        AgencyRoleDto dto = new AgencyRoleDto();
        dto.setName("业务顾问");
        dto.setDescription("这是个业务顾问XXx");
        List<AgencyRoleMenuDto> menuList = new ArrayList<>();
        AgencyRoleMenuDto menuDto = new AgencyRoleMenuDto();
        menuDto.setId(UUID.fromString("fb4a45ed-1142-4c6c-b296-f8c89474c65e"));
        menuList.add(menuDto);
        dto.setAuthList(menuList);
        roleService.addOrUpdateRole(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteBatch() throws Exception {
    }

}