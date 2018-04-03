package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
public interface AgencyRoleRepository extends BaseRepository<AgencyRole,UUID>{

    @Modifying
    @Query(value = "delete from AgencyRole  where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);


    @Modifying
    @Query(value = "delete from sys_ag_user_role  where roleId = :roleId",nativeQuery = true)
    void deleteRoleUserRel(@Param("roleId") String id);
}
