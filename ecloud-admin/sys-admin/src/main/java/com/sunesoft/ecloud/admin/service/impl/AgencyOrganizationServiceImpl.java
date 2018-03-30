package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.repository.AgencyOrganizationRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.cretiria.OrderTurn;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 组织架构ServiceImpl
 */
@Service
@Transactional
public class AgencyOrganizationServiceImpl implements AgencyOrganizationService {

    @Autowired
    AgencyOrganizationRepository orgRepository;
    @Autowired
    AgencyRepository agencyRepository;
    @Value("${ecloud.agId}")
    private UUID agId;
    @Override
    public TResult addOrUpdateOrganization(AgencyOrganizationDto agencyOrganizationDto) {

        UUID parentId = agencyOrganizationDto.getParentId();
        UUID id = agencyOrganizationDto.getId();
        AgencyOrganization org ;
        if(null == id){//新增
            org = new AgencyOrganization();
        }else{//修改
            org = orgRepository.findOne(id);
        }
        //基础信息
        org.setName(agencyOrganizationDto.getName());
        org.setCode(agencyOrganizationDto.getCode());
        org.setDescription(agencyOrganizationDto.getDescription());
        //设置所属企业
        Agency agency = agencyRepository.getOne(agId);
        if(null ==  agency){
            throw new IllegalArgumentException("无效的企业id");
        }
        org.setAgency(agency);
        //设置上级部门
        if(parentId != null){
            AgencyOrganization parentOrg = orgRepository.getOne(parentId);
            if(null == parentOrg){
                throw new IllegalArgumentException("无效的上级id");
            }
            org.setParentOrg(parentOrg);
        }
        //设置负责人
        org.setLeaderId(agencyOrganizationDto.getLeaderId());
        orgRepository.saveAndFlush(org);
        return new TResult<>(agencyOrganizationDto);
    }

    @Override
    public TResult delete(UUID id) {
        orgRepository.delete(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        orgRepository.deleteBatch(ids);
        return (TResult) ResultFactory.success();
    }
}
