package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/29
 */
public interface AgencyAuthorizedMenuRepository extends BaseRepository<AgencyAuthorizedMenu,UUID>{


    @Query(value = "select au.menuId from sys_ag_authmenu au where au.agId =:agId",nativeQuery = true)
    List<String> getMenuId(@Param("agId")String agId);

    @Query(value = "select au.Id from sys_ag_authmenu au where au.menuId in ?1",nativeQuery = true)
    List<String> getDeleteId(List<String> menuId);

    @Query(value = "select * from sys_ag_authmenu au where au.menuId in ?1",nativeQuery = true)
    List<AgencyAuthorizedMenu> getAgencyAuthMenu(List<String> muIds);

    @Modifying
    @Query(value = "delete from sys_ag_authmenu  where id in (:ids)",nativeQuery = true)
    void deleteByIdBatch(@Param("ids") List<String> deleteId);

}
