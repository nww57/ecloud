package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCretiria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jzj on 2018/3/26.
 */
public interface AgencyCustomerQueryService {

    /**
     * 客户信息列表查询
     * @param cretiria 查询参数
     * @return 返回查询结果
     */
    Page<AgencyCustomerDto> findAgencyCustomerPaged(Pageable pageable, AgencyCustomerCretiria cretiria);
}
