package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.repository.AgencyRoleAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleMenuDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.java2d.pipe.SpanIterator;


import java.util.*;


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
    @Autowired
    AgencyRoleAuthorizedMenuRepository repository;


    @Test
    public void addOrUpdateRole() throws Exception {
        AgencyRoleDto dto = new AgencyRoleDto();
        dto.setId(UUID.fromString("9ef4707f-16a2-4654-b598-ddce9973b1cc"));
        dto.setName("测试看看能不能改");
        dto.setDescription("s2323这是个业务顾问XXx");

        Map<UUID,List<UUID>> map = new HashMap<>();
        List<UUID> func = new ArrayList<UUID>(){{
//            add(UUID.fromString("2db1a3a4-84af-445f-b379-aeb17d6d08d0"));
            add(UUID.fromString("ab855fe2-5eba-4589-8e1a-4c177d3fe4ff"));
            add(UUID.fromString("e8fe678e-bef0-4f2a-af97-f387aa8bdc37"));
        }};
        map.put(UUID.fromString("669ff8e0-9db4-4089-85bb-cafb1e2a64d8"),func);
        dto.setAuthList(map);

        roleService.addOrUpdateRole(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteBatch() throws Exception {
    }


    @Test
    public void deleteRepository(){
        repository.delete(UUID.fromString("98a218ce-75c0-405c-aca9-39f34af63d94"));
        System.out.println(23);
    }
}