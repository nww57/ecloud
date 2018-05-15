package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyCustomerQueryService;
import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.annotation.IgnoreUserToken;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerApplicantCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerContactCriteria;
import com.sunesoft.ecloud.adminclient.cretirias.CustomerInventorCriteria;
import com.sunesoft.ecloud.adminclient.dtos.*;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agency/customer")
public class AgencyCustomerController {

    @Autowired
    AgencyCustomerService agencyCustomerService;

    @Autowired
    AgencyCustomerQueryService agencyCustomerQueryService;

    /**
     * 客户查询
     */
    @GetMapping("search")
    public PagedResult<AgencyCustomerDto> search (AgencyCustomerCriteria agencyCustomerCriteria) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyCustomerCriteria.setAgId(agId);
        return agencyCustomerQueryService.findAgencyCustomerPaged(agencyCustomerCriteria);
    }

    /**
     * 获取客户信息
     * @param id
     */
    @GetMapping("{id}")
    public TResult<AgencyCustomerDto> getInfo (@PathVariable UUID id) {
        return agencyCustomerQueryService.findAgencyCustomerBasicById(id);
    }

    /**
     * 新增客户信息
     * @param agencyCustomerDto
     * @return
     */
    @PostMapping("")
    public TResult addInfo (@RequestBody AgencyCustomerDto agencyCustomerDto) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyCustomerDto.setAgId(agId);
        return agencyCustomerService.addOrUpdateAgencyCustomer(agencyCustomerDto);
    }

    /**
     * 修改客户信息
     * @param id
     */
    @PutMapping("{id}")
    public TResult updateInfo (@PathVariable UUID id, @RequestBody AgencyCustomerDto agencyCustomerDto) {
        agencyCustomerDto.setId(id);
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyCustomerDto.setAgId(agId);
        return agencyCustomerService.addOrUpdateAgencyCustomer(agencyCustomerDto);
    }

    /**
     * 删除客户
     * @param ids
     */
    @DeleteMapping("")
    public void deleteCustomer (@RequestParam UUID... ids) {
        agencyCustomerService.deleteBatch(ids);
    }

    /**
     * 申请人查询
     * @param id （客户id）
     * @param criteria
     * @return
     */
    @GetMapping("{id}/applicant")
    public PagedResult<CustomerApplicantDto> applicantSearch (@PathVariable UUID id, CustomerApplicantCriteria criteria) {
        return agencyCustomerQueryService.findCustomerApplicantPaged(id, criteria);
    }

    /**
     * 申请人详情
     * @param cid
     * @param id
     */
    @GetMapping("{cid}/applicant/{id}")
    public void getApplicant (@PathVariable UUID cid, @PathVariable UUID id) {
//        return agencyCustomerQueryService.
    }

    /**
     * 申请人新增
     * @param customerApplicantDto
     * @return
     */
    @PostMapping("{id}/applicant")
    public TResult addApplicant (@PathVariable UUID id, @RequestBody CustomerApplicantDto customerApplicantDto) {
        customerApplicantDto.setCustomerId(id);
        return agencyCustomerService.addOrUpdateCustomerApplicants(customerApplicantDto);
    }

    /**
     * 申请人更新
     * @param cid (客户id)
     * @param customerApplicantDto
     * @param id (申请人id)
     * @return
     */
    @PutMapping("{cid}/applicant/{id}")
    public TResult updateApplicant (@PathVariable UUID cid,
                                    @PathVariable UUID id,
                                    @RequestBody CustomerApplicantDto customerApplicantDto) {
        customerApplicantDto.setCustomerId(cid);
        customerApplicantDto.setId(id);
        return agencyCustomerService.addOrUpdateCustomerApplicants(customerApplicantDto);
    }

    /**
     * 删除申请人
     * @param ids
     */
    @DeleteMapping("applicant")
    public void deleteApplicant (@RequestParam UUID... ids) {
        agencyCustomerService.deleteCustomerApplicants(ids);
    }

    /**
     * 发明人查询
     * @param cid
     * @param criteria
     * @return
     */
    @GetMapping("{cid}/inventor")
    public PagedResult<CustomerInventorDto> inventorSearch (@PathVariable UUID cid, CustomerInventorCriteria criteria) {
        return agencyCustomerQueryService.findCustomerInventorPaged(cid, criteria);
    }

    /**
     * 发明人新增
     * @param cid
     * @param customerInventorDto
     * @return
     */
    @PostMapping("{cid}/inventor")
    public TResult addInventor (@PathVariable UUID cid, @RequestBody CustomerInventorDto customerInventorDto) {
        customerInventorDto.setCustomerId(cid);
        return agencyCustomerService.addOrUpdateCustomerInventor(customerInventorDto);
    }

    /**
     * 发明人修改
     * @param cid
     * @param id
     * @param customerInventorDto
     * @return
     */
    @PutMapping("{cid}/inventor/{id}")
    public TResult updateInventor (@PathVariable UUID cid,
                                   @PathVariable UUID id,
                                   @RequestBody CustomerInventorDto customerInventorDto) {
        customerInventorDto.setCustomerId(cid);
        customerInventorDto.setId(id);
        return agencyCustomerService.addOrUpdateCustomerInventor(customerInventorDto);
    }

    /**
     * 删除发明人
     * @param ids
     */
    @DeleteMapping("inventor")
    public void deleteInventor (@RequestParam UUID... ids) {
        agencyCustomerService.deleteCustomerInventor(ids);
    }



    /**
     * 联系查询
     * @param cid
     * @param criteria
     * @return
     */
    @GetMapping("{cid}/contact")
    public PagedResult<CustomerContactDto> contactSearch (@PathVariable UUID cid, CustomerContactCriteria criteria) {
        return agencyCustomerQueryService.findCustomerContactsPaged(cid, criteria);
    }

    /**
     * 联系人新增
     * @param cid
     * @param customerContactDto
     * @return
     */
    @PostMapping("{cid}/contact")
    public TResult addContact (@PathVariable UUID cid, @RequestBody CustomerContactDto customerContactDto) {
        customerContactDto.setCustomerId(cid);
        return agencyCustomerService.addOrUpdateCustomerContact(customerContactDto);
    }

    /**
     * 联系人修改
     * @param cid
     * @param id
     * @param customerContactDto
     * @return
     */
    @PutMapping("{cid}/contact/{id}")
    public TResult updateContact (@PathVariable UUID cid,
                                  @PathVariable UUID id,
                                  @RequestBody CustomerContactDto customerContactDto) {
        customerContactDto.setCustomerId(cid);
        customerContactDto.setId(id);
        return agencyCustomerService.addOrUpdateCustomerContact(customerContactDto);
    }

    /**
     * 删除联系人
     * @param ids
     */
    @DeleteMapping("contact")
    public void deleteContact (@RequestParam UUID... ids) {
        agencyCustomerService.deleteCustomerContacts(ids);
    }

    /**
     * 获取机构下对应客户列表
     * @param
     * @return
     */
    @GetMapping("agencyCustomer")
    public ListResult<AgencyCustomerBasicDto> getAgencyCustomer(){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        return agencyCustomerQueryService.getAgencyCustomerBasicInfo(agId);
    }

    @IgnoreUserToken
    @PostMapping("applicantIdList")
    public ListResult<CustomerApplicantDto> getCustomerApplicantByIdList(@RequestParam List<UUID> idList){
        return agencyCustomerQueryService.findCustomerApplicantByIdList(idList);
    }

    @IgnoreUserToken
    @PostMapping("inventorIdList")
    public ListResult<CustomerInventorDto> getCustomerInventorByIdList(@RequestParam List<UUID> idList){
        return agencyCustomerQueryService.findCustomerInventorByIdList(idList);
    }

}
