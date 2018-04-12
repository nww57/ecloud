package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerContactDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 */
public interface AgencyCustomerService {

    /**
     * 新增/修改 客户信息
     * @param agencyCustomerDto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateAgencyCustomer(AgencyCustomerDto agencyCustomerDto);

    /**
     * 删除操作
     * @param id id
     * @return 返回操作结果
     */
    TResult delete(UUID id);

    /**
     * 批量删除操作
     * @param ids ids
     * @return 返回操作结果
     */
    TResult deleteBatch(UUID... ids);


    /**
     * 添加或修改客户申请人信息
     * @param applicantsDto 操作参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCustomerApplicants(CustomerApplicantDto applicantsDto);


    /**
     * 删除客户申请人信息
     * @param id id
     * @return 返回操作结果
     */
    TResult deleteCustomerApplicants(UUID... id);

    /**
     * 添加或修改客户发明人信息
     * @param inventorDto 操作参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCustomerInventor(CustomerInventorDto inventorDto);

    /**
     * 删除客户发明人信息
     * @param id
     * @return
     */
    TResult deleteCustomerInventor(UUID... id);

    /**
     * 添加或修改客户联系人信息
     * @param contactsDto 操作参数
     * @return 返回操作结果
     */
    TResult addOrUpdateCustomerContact(CustomerContactDto contactsDto);


    /**
     * 删除客户联系人信息
     * @param id id
     * @return 返回操作结果
     */
    TResult deleteCustomerContacts(UUID... id);
}
