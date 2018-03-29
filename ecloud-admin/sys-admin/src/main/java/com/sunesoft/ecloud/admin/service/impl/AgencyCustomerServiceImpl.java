package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyCustomer;
import com.sunesoft.ecloud.admin.repository.AgencyCustomerRepository;
import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
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
    AgencyCustomerRepository customerRepository;

    @Override
    public TResult addOrUpdateAgencyCustomer(AgencyCustomerDto agencyCustomerDto) {
        UUID id = agencyCustomerDto.getId();
        AgencyCustomer customer;
        if(null == id){
            customer = new AgencyCustomer();
        }else{
            customer = customerRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(agencyCustomerDto,customer);
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
}
