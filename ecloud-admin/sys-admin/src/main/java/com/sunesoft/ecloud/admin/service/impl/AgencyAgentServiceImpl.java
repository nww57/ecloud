package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAgent;
import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.repository.AgencyAgentRepository;
import com.sunesoft.ecloud.admin.service.AgencyAgentService;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 */
@Service
@Transactional
public class AgencyAgentServiceImpl implements AgencyAgentService {
    @Autowired
    AgencyAgentRepository agentRepository;

    @Override
    public TResult addOrUpdateAgencyAgent(AgentDto agentDto) {

        //检查参数
        TResult checkResult = checkParam(agentDto);
        if(!checkResult.getIs_success()){
            return checkResult;
        }
        UUID id = agentDto.getId();
        AgencyAgent agent ;
        if(null == id){
            agent = new AgencyAgent();
        }else{
            agent = agentRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(agentDto,agent);
        agentRepository.saveAndFlush(agent);
        return ResultFactory.success();
    }



    @Override
    public TResult deleteAgencyAgent(UUID... id) {
        agentRepository.deleteByIdIn(id);
        return ResultFactory.success();
    }

    @Override
    public TResult<Boolean> checkLicenseCodeExist(String licenseCode) {
        if(StringUtils.isEmpty(licenseCode)){
            return new TResult<>("执业证号不能为空");
        }
        return checkLicenseCodeExist(null,null,licenseCode);
    }


    private TResult<Boolean> checkLicenseCodeExist(UUID agId,UUID id,String licenseCode) {

        Specification querySpecification = (Specification<AgencyAgent>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(null != agId){
                predicates.add(criteriaBuilder.equal(root.get("agId"), agId));
            }
            if(null != id){
                predicates.add(criteriaBuilder.notEqual(root.get("id"), id));
            }
            if(null != licenseCode){
                predicates.add(criteriaBuilder.equal(root.get("licenseCode"), licenseCode));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<AgencyAgent> agentList  = agentRepository.findAll(querySpecification);
        if(null != agentList && agentList.size() >0){
            return new TResult<>(true);
        }
        return new TResult<>(false);
    }

    private TResult checkParam(AgentDto agentDto) {
        if(null == agentDto.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        if(StringUtils.isEmpty(agentDto.getName())){
            return new TResult("姓名不能为null");
        }
        if(StringUtils.isEmpty(agentDto.getLicenseCode())){
            return new TResult("执业证号不能为null");
        }
        if(StringUtils.isEmpty(agentDto.getCellphone())){
            return new TResult("手机号不能为null");
        }
        TResult<Boolean> checkResult = checkLicenseCodeExist(agentDto.getAgId(),agentDto.getId(),agentDto.getLicenseCode());
        if(checkResult.getResult()){
            return new TResult("执业证号已经存在");
        }
        return ResultFactory.success();
    }
}
