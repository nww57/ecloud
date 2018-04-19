package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.CaseMessage;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public interface CaseMessageRepository extends BaseRepository<CaseMessage,UUID> {

    @Query(value = "select DISTINCT messagerId from case_message cm where cm.id in :ids",nativeQuery = true)
    List<String> queryMessager(@Param("ids") List<String> ids);

    @Modifying
    @Query(value = "delete from CaseMessage where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);
}
