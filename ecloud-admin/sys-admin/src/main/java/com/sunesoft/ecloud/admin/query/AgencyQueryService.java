package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import org.springframework.data.domain.Page;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业查询
 */
public interface AgencyQueryService {

    /**
     * 查询企业信息
     * @param criteria 查询参数
     * @return 返回查询信息
     */
    Page<AgencyDto> findAgencyPaged( AgencyCriteria criteria);
}
