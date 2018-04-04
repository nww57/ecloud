package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public interface AgencyOrganizationRepository extends BaseRepository<AgencyOrganization,UUID>,JpaSpecificationExecutor {

    @Modifying
    @Query(value = "delete from AgencyOrganization where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);

    void deleteByAgency_Id(UUID agId);

    @Modifying
    @Query(value = "update AgencyOrganization a set a.parentOrg = null where a.parentOrg.id = :pid")
    void updateParentAgencyNull(@Param("pid") UUID pid);


    AgencyOrganization findByAgency_IdAndNameEquals(UUID agId,String name);

    AgencyOrganization findByAgency_IdAndIdNotAndNameEquals(UUID agId,UUID id,String name);

    AgencyOrganization findByAgency_IdAndCodeEquals(UUID agId,String code);

    AgencyOrganization findByAgency_IdAndIdNotAndCodeEquals(UUID agId,UUID id,String code);
}
