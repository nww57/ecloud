package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;


import feign.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/29

 */
@Repository
public interface AgencyAuthorizedMenuRepository extends BaseRepository<AgencyAuthorizedMenu,UUID>{


    @Query(value = "select au.MenuId from sys_ag_authmenu au where au.agId = ?1",nativeQuery = true)
    List<UUID> getMenuId(UUID agId);

    @Query(value = "select au.Id from sys_ag_authmenu au where au.menuId in ?1",nativeQuery = true)
    List<UUID> getDeleteId(List<UUID> menuIds);

    @Modifying
    @Query(value = "delete from AgencyAuthorizedMenu au where au.id in (:ids)")
    void deleteByIdBatch(@Param("ids") List<UUID> deleteId);

}
