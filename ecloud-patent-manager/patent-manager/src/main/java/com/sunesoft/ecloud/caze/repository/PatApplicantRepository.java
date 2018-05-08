package com.sunesoft.ecloud.caze.repository;

import com.netflix.ribbon.proxy.annotation.ClientProperties;
import com.sunesoft.ecloud.caze.domain.PatApplicant;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
public interface PatApplicantRepository extends BaseRepository<PatApplicant,UUID>{

    @Modifying
    @Query(value = "delete from PatApplicant where patentInfo.id = :patentId")
    void deleteByPatent(@Param("patentId") UUID patentId);

    @Query(value = "select * from pat_applicant a where a.patentId = :patentId and a.sort< :sort order by a.sort desc limit 0,1",nativeQuery = true)
    PatApplicant getUp(@Param("patentId") String patentId,@Param("sort") int sort);


    @Query(value = "select * from pat_applicant a where a.patentId = :patentId and a.sort> :sort order by a.sort asc limit 0,1",nativeQuery = true)
    PatApplicant getDown(@Param("patentId") String patentId,@Param("sort") int sort);

}
