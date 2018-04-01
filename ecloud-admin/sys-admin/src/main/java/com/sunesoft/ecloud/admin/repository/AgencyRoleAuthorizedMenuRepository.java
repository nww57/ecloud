package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyRoleAuthorizedMenu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/29
 */
public interface AgencyRoleAuthorizedMenuRepository extends JpaRepository<AgencyRoleAuthorizedMenu,UUID> {

    @Query(value = "select r.Id from sys_ag_role_authmenu r where r.menuId in ?1" ,nativeQuery = true)
    List<String>  getIdByAgencyMenu(List<String> ids);


    @Query(value = "select rolemenu.id from sys_ag_authmenu agmenu left join sys_ag_role_authmenu rolemenu on rolemenu.menuId = agmenu.id where agmenu.menuId in ?1",nativeQuery = true)
    List<String> getIdByMenuId(List<String> menuIds);
}
