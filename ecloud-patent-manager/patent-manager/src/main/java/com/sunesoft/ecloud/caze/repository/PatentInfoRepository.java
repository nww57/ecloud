package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
public interface PatentInfoRepository extends BaseRepository<PatentInfo,UUID> {

    @Procedure(procedureName = "generate_caseNo")
    String generateCaseNo(@Param("agId") String agId);

    @Modifying
    @Query(value = "update PatentInfo set is_active =0 where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);

    PatentInfo findByAgIdAndCaseNo(UUID agId,String caseNo);

    PatentInfo findByApplicationNo(String applicationNo);

    @Query(value = "select sa.agencyCode,sa.name from sys_agency sa where sa.id = :agId",nativeQuery = true)
    AgencyBasicDto getAgencyName(@Param("agId") String agId);
}
