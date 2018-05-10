package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyCustomer;
import com.sunesoft.ecloud.admin.repository.AgencyCustomerRepository;
import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.ApplicantType;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerApplicantDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerContactDto;
import com.sunesoft.ecloud.adminclient.dtos.CustomerInventorDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyCustomerServiceImplTest {

    @Autowired
    AgencyCustomerService customerService;
    @Autowired
    AgencyCustomerRepository customerRepository;

    @Test
    public void addOrUpdateAgencyCustomer() throws Exception {
        AgencyCustomerDto dto  = new AgencyCustomerDto();
        dto.setName("客户1");
        dto.setLeader("负责人1");
        dto.setLeaderEmail("123123@163.com");
        dto.setLeaderMobile("1231313123");
        dto.setProvince("北京市");
        dto.setCity("市辖区");
        dto.setDistrict("东城区");
        dto.setStreet("高新区XXX");
        dto.setSignDate(LocalDateTime.now());
        dto.setConsultantId(UUID.fromString("0f35220d-718e-4e53-b260-cb329d7fb407"));
        customerService.addOrUpdateAgencyCustomer(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
        customerService.delete(UUID.fromString("178894eb-9d04-4d23-a79e-927bc952b07c"));
    }

    @Test
    public void deleteBatch() throws Exception {
        customerService.deleteBatch(UUID.fromString("98ca3092-cc29-4214-a67b-4064878d890b"),UUID.fromString("d93cf511-3c1f-4562-905c-93c68b3bee00"));
    }

    @Test
    public void addOrUpdateCustomerApplicants() throws Exception{

            CustomerApplicantDto dto = new CustomerApplicantDto();
            dto.setCustomerId(UUID.fromString("569e07c9-0ebf-4002-88da-87c2777d82f2"));
            dto.setRecord(true);
            dto.setType(ApplicantType.INDUSTRIAL_COMPANY);
            dto.setIdCode("320425363652142536");
            dto.setCountryName("中国");
            dto.setCountryCode("CN");
            dto.setProvinceName("江苏");
            dto.setProvinceCode("3200");
            dto.setCityName("常州");
            dto.setCityCode("3204");
            dto.setAreaDetail("asdf");
            dto.setLiveAddress("asdfasdfasdfasdf");
            dto.setUserCode("a123234");
            TResult result = customerService.addOrUpdateCustomerApplicants(dto);

    }

    @Test
    public void deleteCustomerApplicants(){
        customerService.deleteCustomerApplicants(UUID.fromString("2596f3c9-8055-49f6-9e98-e71477307004"),UUID.fromString("29c34b5f-392a-400b-a976-03cae1b9d2db"),UUID.fromString("33e6b009-7a29-4d3d-8007-f5082294b325"));
        System.out.println(23);
    }

    @Test
    public void addOrUpdateCustomerInventor() throws Exception{
        for(int i= 0;i<14;i++) {
            CustomerInventorDto dto = new CustomerInventorDto();
            dto.setCustomerId(UUID.fromString("569e07c9-0ebf-4002-88da-87c2777d82f2"));
            dto.setName("发明人"+i);
//            dto.setCountry("中国");
//            dto.setCode("320425363652142536");
            dto.setOpen(true);
            TResult result = customerService.addOrUpdateCustomerInventor(dto);
        }
        System.out.println(23);
    }

    @Test
    public void addOrUpdateCustomerContacts() throws Exception{
        for(int i= 0;i<14;i++) {
            CustomerContactDto dto = new CustomerContactDto();
            dto.setCustomerId(UUID.fromString("569e07c9-0ebf-4002-88da-87c2777d82f2"));
            dto.setName("客户联系人"+i);
            dto.setEmail("234@qq.com");
            dto.setQq("2323234");
            TResult result = customerService.addOrUpdateCustomerContact(dto);
        }
        System.out.println(23);
    }

    @Test
    public void test(){
        AgencyCustomer customer = customerRepository.findById(UUID.fromString("ebde1070-5faa-4f74-a22e-963a819bdef7")).get();
        System.out.println(23);
    }
}