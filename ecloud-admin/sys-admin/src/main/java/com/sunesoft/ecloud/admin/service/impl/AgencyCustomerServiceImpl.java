package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.*;
import com.sunesoft.ecloud.admin.repository.*;
import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.AgencyType;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerContactDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
@Transactional
public class AgencyCustomerServiceImpl implements AgencyCustomerService {

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    AgencyCustomerRepository customerRepository;
    @Autowired
    CustomerApplicantRepository applicantRepository;
    @Autowired
    CustomerInventorRepository inventorRepository;
    @Autowired
    CustomerContactRepository contactRepository;

    @Override
    public TResult addOrUpdateAgencyCustomer(AgencyCustomerDto agencyCustomerDto) {


        //参数检查
        TResult checkParamResult = checkParam(agencyCustomerDto);
        if(!checkParamResult.getIs_success()){
            return checkParamResult;
        }
        UUID id = agencyCustomerDto.getId();
        UUID agId = agencyCustomerDto.getAgId();
        AgencyCustomer customer;
        if (null == id) {
            customer = new AgencyCustomer();
            //检查agency中,是否存在agencyType为Customer且name = agencyustomerDto.getName()的数据
            //如果已经存在，则当前客户的customerAgencyId为该agency的id,否则添加一个新的agency,type为Customer
            String name = agencyCustomerDto.getName();
            Agency customerAgency = agencyRepository.findAgencyByNameEqualsAndAgencyTypeEquals(name, AgencyType.Customer);
            if(null == customerAgency){
                customerAgency = new Agency(AgencyType.Customer);
                customerAgency.setName(name);
                customerAgency = agencyRepository.saveAndFlush(customerAgency);
                customer.setCustomerAgencyId(customerAgency.getId());
            }else{
               customer.setCustomerAgencyId(customerAgency.getId());
            }
            Agency agency = agencyRepository.findOne(agId);
            customer.setAgency(agency);
        } else {
            customer = customerRepository.findOne(id);
        }

        BeanUtil.copyPropertiesIgnoreNull(agencyCustomerDto, customer);
        customerRepository.saveAndFlush(customer);
        return new TResult<>(agencyCustomerDto);
    }


    @Override
    public TResult delete(UUID id) {
        customerRepository.delete(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        customerRepository.deleteBatch(ids);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult addOrUpdateCustomerApplicants(CustomerApplicantDto applicantsDto) {
        UUID customerId = applicantsDto.getCustomerId();
        UUID id = applicantsDto.getId();
        if(null == customerId){
            throw new IllegalArgumentException("客户id不能为null");
        }
        CustomerApplicant applicant  = null;
        if(null ==  id){
            applicant = new CustomerApplicant();
        }else{
            applicant = applicantRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(applicantsDto,applicant);
        applicantRepository.save(applicant);
        return ResultFactory.success();
    }

    @Override
    public TResult deleteCustomerApplicants(UUID... id) {
        if(null == id || id.length ==0){
            throw new IllegalArgumentException("参数错误");
        }
        applicantRepository.deleteByIdIn(id);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdateCustomerInventor(CustomerInventorDto inventorDto) {

        UUID customerId = inventorDto.getCustomerId();
        UUID id = inventorDto.getId();
        if(null == customerId){
            throw new IllegalArgumentException("客户id不能为null");
        }
        CustomerInventor inventor  = null;
        if(null ==  id){
            inventor = new CustomerInventor();
        }else{
            inventor = inventorRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(inventorDto,inventor);
        inventorRepository.save(inventor);
        return ResultFactory.success();
    }

    @Override
    public TResult deleteCustomerInventor(UUID... id) {
        if(null == id || id.length ==0){
            throw new IllegalArgumentException("参数错误");
        }
        inventorRepository.deleteByIdIn(id);
        return ResultFactory.success();
    }

    @Override
    public TResult addOrUpdateCustomerContact(CustomerContactDto contactsDto) {
        UUID customerId = contactsDto.getCustomerId();
        UUID id = contactsDto.getId();
        if(null == customerId){
            throw new IllegalArgumentException("客户id不能为null");
        }
        CustomerContact contact  = null;
        if(null ==  id){
            contact = new CustomerContact();
        }else{
            contact = contactRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(contactsDto,contact);
        contactRepository.save(contact);
        return ResultFactory.success();
    }

    @Override
    public TResult deleteCustomerContacts(UUID... id) {
        if(null == id || id.length ==0){
            throw new IllegalArgumentException("参数错误");
        }
        contactRepository.deleteByIdIn(id);
        return ResultFactory.success();
    }

    private TResult checkParam(AgencyCustomerDto agencyCustomerDto) {
        if(null == agencyCustomerDto.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        if (StringUtils.isEmpty(agencyCustomerDto.getName())) {
            return new TResult<>("客户名称不能为空");
        }
        if (StringUtils.isEmpty(agencyCustomerDto.getLeader())) {
            return new TResult<>("负责人不能为空");
        }
        if (StringUtils.isEmpty(agencyCustomerDto.getLeaderMobile())) {
            return new TResult<>("手机号不能为空");
        }
        if (StringUtils.isEmpty(agencyCustomerDto.getLeaderEmail())) {
            return new TResult<>("邮箱不能为空");
        }
        if (StringUtils.isEmpty(agencyCustomerDto.getSignDate())) {
            return new TResult<>("签约时间不能为空");
        }
        return (TResult) ResultFactory.success();
    }
}
