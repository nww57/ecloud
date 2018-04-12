package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.repository.AgencyAgentRepository;
import com.sunesoft.ecloud.admin.service.AgencyAgentService;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 */
@Service
public class AgencyAgentServiceImpl implements AgencyAgentService {

    @Override
    public TResult addOrUpdateAgencyAgent(AgentDto agentDto) {
        return null;
    }

    @Override
    public TResult deleteAgencyAgent(UUID... id) {
        return null;
    }
}
