package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.CaseInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public interface CaseInfoRepository extends BaseRepository<CaseInfo,UUID>{
    @Modifying
    @Query(value = "update CaseInfo set is_active = 0 where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);


    @Procedure(procedureName = "generate_caseNo")
    String generateCaseNo(@Param("agId") String agId);

}
