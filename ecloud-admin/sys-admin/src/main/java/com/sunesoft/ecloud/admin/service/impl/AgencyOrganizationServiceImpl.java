package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.repository.AgencyOrganizationRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.UserPositionType;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.common.cretiria.OrderTurn;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    UserRepository userRepository;

    @Override
    public TResult addOrUpdateOrganization(AgencyOrganizationDto agencyOrganizationDto) {

        //检查参数
        TResult checkResult = checkParam(agencyOrganizationDto);
        if(!checkResult.getIs_success()){
            return checkResult;
        }
        UUID parentId = agencyOrganizationDto.getPid();
        UUID id = agencyOrganizationDto.getId();
        UUID agId = agencyOrganizationDto.getAgId();
        AgencyOrganization org ;
        if(null == id){//新增
            org = new AgencyOrganization();
        }else{//修改
            org = orgRepository.findById(id).get();
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
        //设置负责人 并将负责人的职位改为 “UserPositionType.LEADER”
        if(null != agencyOrganizationDto.getLeaderId()){
            org.setLeaderId(agencyOrganizationDto.getLeaderId());
            userRepository.updatePosition(agencyOrganizationDto.getLeaderId(), UserPositionType.LEADER.getCode());
        }
        orgRepository.saveAndFlush(org);
        return new TResult<>(agencyOrganizationDto);
    }



    @Override
    public TResult delete(UUID id) {
        //与用户的关系断开，更新该组织架构下的用户的所属架构为null
        userRepository.updateOrganizationNull(id);
        //与下级的关系断开
        orgRepository.updateParentAgencyNull(id);
        orgRepository.deleteById(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        for (UUID id : ids) {
            delete(id);
        }
        return (TResult) ResultFactory.success();
    }



    @Override
    public TResult<Boolean> checkOrganizationNameExist(UUID agId,UUID id, String name) {
        Specification querySpecification = (Specification<AgencyOrganization>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            predicateList.add(criteriaBuilder.equal(root.get("agency").get("id"), agId));
            if(null != name){
                predicateList.add(criteriaBuilder.equal(root.get("name"), name));
            }
            if(null != id){
                predicateList.add(criteriaBuilder.notEqual(root.get("id"), id));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
        List<AgencyOrganization> orgList  = orgRepository.findAll(querySpecification);
        if(null != orgList && orgList.size() >0){
            return new TResult<>(true);
        }
        return new TResult<>(false);
    }


    @Override
    public TResult<Boolean> checkOrganizationCodeExist(UUID agId,UUID id, String code) {
        Specification querySpecification = (Specification<AgencyOrganization>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("agency").get("id"), agId));
            if(null != id){
                predicates.add(criteriaBuilder.notEqual(root.get("id"), id));
            }
            if(null != code){
                predicates.add(criteriaBuilder.equal(root.get("code"), code));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<AgencyOrganization> orgList  = orgRepository.findAll(querySpecification);
        if(null != orgList && orgList.size() >0){
            return new TResult<>(true);
        }
        return new TResult<>(false);
    }


    private TResult checkParam(AgencyOrganizationDto agencyOrganizationDto) {
        if(null == agencyOrganizationDto.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        if(StringUtils.isEmpty(agencyOrganizationDto.getName())){
            return new TResult("部门名称不能为空");
        }
        if(StringUtils.isEmpty(agencyOrganizationDto.getCode())){
            return new TResult("编码不能为空");
        }
        if(StringUtils.isEmpty(agencyOrganizationDto.getCode())){
            return new TResult("描述不能为空");
        }
        TResult<Boolean> nameExistResult = checkOrganizationNameExist(agencyOrganizationDto.getAgId(),agencyOrganizationDto.getId(),agencyOrganizationDto.getName());
        if(nameExistResult.getIs_success()){
            if(nameExistResult.getResult()){
                return new TResult("部门名称已经存在");
            }
        }
        TResult<Boolean> codeExistResult = checkOrganizationCodeExist(agencyOrganizationDto.getAgId(),agencyOrganizationDto.getId(),agencyOrganizationDto.getCode());
        if(codeExistResult.getIs_success()){
            if(codeExistResult.getResult()){
                return new TResult("部门编码已经存在");
            }
        }
        return (TResult) ResultFactory.success();
    }
}
