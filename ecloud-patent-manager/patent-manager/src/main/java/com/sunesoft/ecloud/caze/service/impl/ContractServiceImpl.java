package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.caze.repository.ContractInfoRepository;
import com.sunesoft.ecloud.caze.service.ContractService;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractInfoRepository contractInfoRepository;

    @Override
    public TResult addOrUpdateContract(ContractDto dto) {
        return null;
    }

    @Override
    public TResult deleteContract(UUID... ids) {
        return null;
    }
}
