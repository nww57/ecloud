package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.caseclient.criterias.ContractQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.ContractDetailDto;
import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.caseclient.dto.ContractPatentInfo;
import com.sunesoft.ecloud.caseclient.dto.CreateContractPatentDto;
import com.sunesoft.ecloud.caze.query.ContractQueryService;
import com.sunesoft.ecloud.caze.service.ContractService;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by wangguangyang on 2018/5/4.
 */
@RestController
@RequestMapping("/contractManager")
public class ContractController {

    @Autowired
    ContractQueryService contractQueryService;
    @Autowired
    ContractService contractService;
    @Autowired
    PatentService patentService;

    /**
     * 查询合同列表
     *
     * @param criteria
     * @return
     */
    @GetMapping("search")
    public PagedResult<ContractDto> search(ContractQueryCriteria criteria) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        criteria.setAgId(agId);
        return contractQueryService.queryContractPaged(criteria);
    }

    /**
     * 获取合同详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<ContractDetailDto> getInfo(@PathVariable UUID id) {
        return contractQueryService.getContractDetailById(id);
    }

    /**
     * 新增合同
     * @param dto
     * @return
     */
    @PostMapping("")
    public TResult addContract(@RequestBody ContractDto dto){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        UUID userId=UUID.fromString(UserContext.getUserID());
        dto.setAgId(agId);
        dto.setCreatorId(userId);
        return contractService.addOrUpdateContract(dto);
    }

    /**
     * 创建合同案件
     * @param cid
     * @param dto
     * @return
     */
    @PostMapping("{cid}/patent")
    public TResult addPatent(@PathVariable UUID cid, @RequestBody CreateContractPatentDto dto){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        UUID userId=UUID.fromString(UserContext.getUserID());
        dto.setAgId(agId);
        dto.setCreatorId(userId);
        dto.setContractId(cid);
        return patentService.addPatent(dto);
    }

    /**
     * 删除合同案件
     * @param ids
     * @return
     */
    @DeleteMapping("patent")
    public TResult deletePatent(@RequestParam UUID... ids){
        return patentService.deletePatent(ids);
    }

    /**
     * 查询合同对应案件列表
     * @param cid
     * @return
     */
    @GetMapping("{cid}/patent")
    public ListResult<ContractPatentInfo> searchPatent(@PathVariable UUID cid){
        return contractQueryService.getContractPatent(cid);
    }

    /**
     * 创建案件流水号
     * @return
     */
    @GetMapping("generateCaseNo")
    public TResult generateCaseNo(){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        return patentService.generateCaseNo(agId);
    }


}
