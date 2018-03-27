package com.sunesoft.ecloud.admin.service.impl;

import com.netflix.discovery.converters.Auto;
import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.repository.AgencyOrganizationRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 组织架构ServiceImpl
 */
@Service
public class AgencyOrganizationServiceImpl implements AgencyOrganizationService {

    @Autowired
    AgencyOrganizationRepository orgRepository;
    @Autowired
    AgencyRepository agencyRepository;

    @Override
    public TResult addOrUpdateOrganization(AgencyOrganizationDto agencyOrganizationDto) {

        UUID agId = agencyOrganizationDto.getAgId();
        Agency agency = agencyRepository.getOne(agId);
        if(null ==  agency){
            throw new IllegalArgumentException("无效的企业id");
        }

        UUID parentId = agencyOrganizationDto.getParentId();
        AgencyOrganization parentOrg = orgRepository.getOne(parentId);
        if(null == parentOrg){
            throw new IllegalArgumentException("无效的上级id");
        }

        UUID id = agencyOrganizationDto.getId();
        AgencyOrganization org ;
        if(null == id){//新增
            org = new AgencyOrganization();
        }else{//修改
            org = orgRepository.getOne(id);
        }
        org.setAgency(agency);
        org.setName(agencyOrganizationDto.getName());
        org.setCode(agencyOrganizationDto.getCode());
        org.setDescription(agencyOrganizationDto.getDescription());
        org.setLeaderId(agencyOrganizationDto.getLeaderId());
        org.setParentOrg(parentOrg);
        orgRepository.saveAndFlush(org);
        return new TResult<>(agencyOrganizationDto);
    }

    @Override
    public TResult delete(UUID id) {
        return null;
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        return null;
    }
}
