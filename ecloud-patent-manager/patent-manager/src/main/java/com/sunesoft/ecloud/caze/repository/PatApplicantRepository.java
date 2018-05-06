package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatApplicant;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import feign.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
public interface PatApplicantRepository extends BaseRepository<PatApplicant,UUID>{

    @Modifying
    @Query(value = "delete from PatApplicant where patentInfo.id = :patentId")
    void deleteByPatent(@Param("patentId") UUID patentId);
}
