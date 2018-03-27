package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业客户查询
 */
public interface AgencyCustomerQueryService {

    /**
     * 客户信息列表查询
     * @param criteria 查询参数
     * @return 返回查询结果
     */
    Page<AgencyCustomerDto> findAgencyCustomerPaged(AgencyCustomerCriteria criteria);
}
