package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatentInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public interface PatentInfoRepository extends BaseRepository<PatentInfo,UUID>{

    @Modifying
    @Query(value = "update PatentInfo set customerId = :customerId,feeReduceRate = :feeReduceRate where caseInfo.id = :caseId")
    void updatePatentInfo(@Param("caseId") UUID caseId, @Param("customerId") UUID customerId, @Param("feeReduceRate") BigDecimal feeReduceRate);
}
