package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public interface AgencyRepository extends BaseRepository<Agency,UUID> {

    /**
     * 根据机构编码查找
     * @param code 编码
     * @return 返回信息
     */
    Agency findByCodeEquals(String code);
}
