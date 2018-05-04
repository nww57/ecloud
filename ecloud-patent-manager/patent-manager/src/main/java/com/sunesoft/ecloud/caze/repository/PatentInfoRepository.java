package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
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
}
