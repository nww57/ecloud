package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.caze.domain.ContractInfo;
import com.sunesoft.ecloud.caze.repository.ContractInfoRepository;
import com.sunesoft.ecloud.caze.service.ContractService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractInfoRepository contractInfoRepository;

    @Override
    public TResult generateContractNo(UUID agId) {
        if(null == agId){
            throw new IllegalArgumentException("无效的agId");
        }
        Object contract = contractInfoRepository.generateContractNo(agId.toString());
        return new TResult<>(contract);
    }

    @Override
    public TResult addOrUpdateContract(ContractDto dto) {
        //参数检查
        if(null == dto.getCreatorId()){
            throw new IllegalArgumentException("创建人id不能为null");
        }
        UUID id = dto.getId();
        ContractInfo info ;
        if(null == id){
            info = new ContractInfo();
        }else{
            info = contractInfoRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(dto,info);
        contractInfoRepository.saveAndFlush(info);
        return ResultFactory.success(info.getId());
    }

    @Override
    public TResult deleteContract(UUID id) {
        contractInfoRepository.deleteBatch(id);
        return ResultFactory.success();
    }

    @Override
    public TResult deleteContract(UUID... ids) {
        contractInfoRepository.deleteBatch(ids);
        return ResultFactory.success();
    }
}
