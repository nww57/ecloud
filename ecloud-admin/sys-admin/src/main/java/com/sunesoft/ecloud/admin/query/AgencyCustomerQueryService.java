package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;

import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerContactsDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

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

    PagedResult<AgencyCustomerDto> findAgencyCustomerPaged(AgencyCustomerCriteria criteria);

    /**
     * 根据id查询客户信息
     * @param id 客户id
     * @return 返回查询结果
     */
    TResult<AgencyCustomerDto> findAgencyCustomerBasicById(UUID id);



    /**
     *
     * @param pageable
     * @param customerId
     * @return
     */
    PagedResult<CustomerApplicantDto> findCustomerApplicantPaged(UUID customerId,Pageable pageable);


    /**
     *
     * @param pageable
     * @param customerId
     * @return
     */
    PagedResult<CustomerInventorDto> findCustomerInventorPaged(UUID customerId,Pageable pageable);


    /**
     *
     * @param pageable
     * @param customerId
     * @return
     */
    PagedResult<CustomerContactsDto> findCustomerContactsPaged(UUID customerId,Pageable pageable);


}
