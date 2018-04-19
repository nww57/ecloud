package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyAgentQueryService;
import com.sunesoft.ecloud.admin.service.AgencyAgentService;
import com.sunesoft.ecloud.adminclient.cretirias.AgentCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgentDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by wangguangyang on 2018/4/13.
 */
@RestController
@RequestMapping("/agency/agent")
public class AgencyAgentController {

    @Autowired
    AgencyAgentQueryService agencyAgentQueryService;
    @Autowired
    AgencyAgentService agencyAgentService;

    /**
     * 查询代理人列表信息
     * @param criteria
     * @return
     */
    @GetMapping("search")
    public PagedResult<AgentDto> search(AgentCriteria criteria){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        criteria.setAgId(agId);
        return  agencyAgentQueryService.findAgentPaged(criteria);
    }

    /**
     * 新增代理人
     * @param agentDto
     * @return
     */
    @PostMapping("")
    public TResult addAgent (@RequestBody AgentDto agentDto) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agentDto.setAgId(agId);
        return agencyAgentService.addOrUpdateAgencyAgent(agentDto);
    }

    /**
     * 删除代理人
     * @param ids
     */
    @DeleteMapping("")
    public void deleteAgent(@RequestParam UUID... ids){
        agencyAgentService.deleteAgencyAgent(ids);
    }

    /**
     * 更新代理人
     * @param id
     * @param agentDto
     * @return
     */
    @PutMapping("{id}")
    public TResult updateAgent(@PathVariable UUID id,@RequestBody AgentDto agentDto){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agentDto.setAgId(agId);
        agentDto.setId(id);
        return agencyAgentService.addOrUpdateAgencyAgent(agentDto);
    }


}
