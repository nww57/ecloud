package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;

import java.util.UUID;

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
    Page<AgencyDto> findAgencyPaged(AgencyCriteria criteria);

    /**
     * 根据id获取企业基本信息
     * @return 返回查询结果
     */
    TResult<AgencyBasicDto> findAgencyBasicInfo();

    /**
     * 根据id获取企业基本信息
     * @param id 企业id
     * @return 返回查询结果
     */
    TResult<AgencyBasicDto> findAgencyBasicInfoById(UUID id);

    /**
     * 根据id获取详细信息
     * @param id 企业id
     * @return 返回查询结果
     */
    TResult<AgencyDto> findAgencyDetailInfoById(UUID id);
}
