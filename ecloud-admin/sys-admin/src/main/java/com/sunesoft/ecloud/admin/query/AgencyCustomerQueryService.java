package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.admin.domain.agency.CustomerContact;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerApplicantCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerContactCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerInventorCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerContactDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
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
     * 查找客户申请人列表
     * @param customerId 客户id
     * @param criteria  分页参数
     * @return 返回查询结果
     */
    PagedResult<CustomerApplicantDto> findCustomerApplicantPaged(UUID customerId, CustomerApplicantCriteria criteria);

    /**
     * 根据id 查找客户申请人信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<CustomerApplicantDto> findCustomerApplicantById(UUID id);


    /**
     * 查找客户发明人列表
     * @param customerId 客户id
     * @param criteria 分页参数
     * @return 返回查询结果
     */
    PagedResult<CustomerInventorDto> findCustomerInventorPaged(UUID customerId,CustomerInventorCriteria criteria);

    /**
     * 根据id 查找客户发明人信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<CustomerInventorDto> findCustomerInventorById(UUID id);

    /**
     * 查找客户联系人信息
     * @param customerId 客户id
     * @param criteria 分页参数
     * @return 返回查询结果
     */
    PagedResult<CustomerContactDto> findCustomerContactsPaged(UUID customerId, CustomerContactCriteria criteria);

    /**
     * 根据id 查找客户联系人信息
     * @param id id
     * @return 返回查询结果
     */
    TResult<CustomerContactDto> findCustomerContactById(UUID id);

}
