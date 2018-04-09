package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyCustomer;
import com.sunesoft.ecloud.admin.repository.AgencyCustomerRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        } else {
            customer = customerRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(agencyCustomerDto, customer);
        Agency agency = agencyRepository.findOne(agId);
        customer.setAgency(agency);
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
