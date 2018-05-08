package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatAgent;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
public interface PatAgentRepository extends BaseRepository<PatAgent,UUID>{

    @Modifying
    @Query(value = "delete from PatAgent where patentInfo.id = :patentId")
    void deleteByPatent(@Param("patentId") UUID patentId);

    @Query(value = "select * from pat_agent a where a.patentId = :patentId and a.sort< :sort order by a.sort desc limit 0,1",nativeQuery = true)
    PatAgent getUp(@Param("patentId") String patentId, @Param("sort") int sort);


    @Query(value = "select * from pat_agent a where a.patentId = :patentId and a.sort> :sort order by a.sort asc limit 0,1",nativeQuery = true)
    PatAgent getDown(@Param("patentId") String patentId,@Param("sort") int sort);
}
