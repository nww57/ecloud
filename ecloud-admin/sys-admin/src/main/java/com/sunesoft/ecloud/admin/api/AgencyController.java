package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyQueryService;
import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    AgencyService agencyService;

    @Autowired
    AgencyQueryService agencyQueryService;

    /**
     * 企业查询
     * @param agencyCriteria
     */
    @GetMapping("search")
    public Page<AgencyDto> search (AgencyCriteria agencyCriteria) {
        return agencyQueryService.findAgencyPaged(agencyCriteria);
    }

    /**
     * 获取企业信息(企业管理)
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult getInfo (@PathVariable UUID id) {
        return agencyQueryService.findAgencyDetailInfoById(id);
    }

    /**
     * 新增企业信息(企业管理)
     * @param agencyDto
     * @return
     */
    @PostMapping("")
    public TResult addInfo (@RequestBody AgencyDto agencyDto) {
        return agencyService.addOrUpdateAgency(agencyDto);
    }

    /**
     * 修改企业信息(企业管理)
     * @param agencyDto
     * @param id
     * @return
     */
    @PutMapping("{id}")
    public TResult updateInfo (@RequestBody AgencyDto agencyDto, @PathVariable UUID id) {
        agencyDto.setId(id);
        return agencyService.addOrUpdateAgency(agencyDto);
    }

    /**
     * 企业信息获取 (获取所属企业的信息)
     * @param id
     * @return
     */
    @GetMapping("basic/{id}")
    public TResult<AgencyBasicDto> getBasicInfo (@PathVariable UUID id) {
        return agencyQueryService.findAgencyBasicInfoById(id);
    }

    /**
     * 修改企业信息(获取所属企业的信息)
     * @param agencyBasicDto
     * @param id
     * @return
     */
    @PutMapping("basic/{id}")
    public TResult updateBasicInfo (@RequestBody AgencyBasicDto agencyBasicDto, @PathVariable UUID id) {
        agencyBasicDto.setId(id);
        return agencyService.updateAgencyBasicInfo(agencyBasicDto);
    }

    /**
     * 删除企业
     * @param ids
     * @return
     */
    @DeleteMapping()
    public TResult delete (@RequestParam UUID... ids) {
        return agencyService.deleteBatch(ids);
    }

}
