package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.NoticeInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
public interface DismissedNoticeRepository extends BaseRepository<NoticeInfo,UUID> {

    @Modifying
    @Query(value = "update NoticeInfo set handleStatus = :status where id in :ids")
    void updateHandleStatus(@Param("status") Boolean status,@Param("ids") UUID... ids);
}
