package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caseclient.dto.PatApplicantDto;
import com.sunesoft.ecloud.caze.domain.PatApplicant;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
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

    List<PatApplicant> findByPatentInfo_Id(UUID patentId);

    @Query(value = "select ca.id as customerApplicantId,ca.name,ca.countryCode,ca.type,ca.idCode,ca.record,ca.provinceCode,ca.cityCode,ca.areaDetail,ca.zipCode,ca.liveAddress,ca.userCode  from customer_applicant ca where ca.id in :idList",nativeQuery = true)
    List<Map<String,Object>> findPatApplicantByIdList(@Param("idList") List<String> idList);
}
