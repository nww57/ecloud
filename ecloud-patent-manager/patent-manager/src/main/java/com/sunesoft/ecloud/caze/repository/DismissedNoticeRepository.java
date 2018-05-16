package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.NoticeInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
public interface DismissedNoticeRepository extends BaseRepository<NoticeInfo,UUID> {
}
