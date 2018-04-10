package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyCustomerQueryService;
import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/agency/customer")
public class AgencyCustomerController {

    @Autowired
    AgencyCustomerService agencyCustomerService;

    @Autowired
    AgencyCustomerQueryService agencyCustomerQueryService;

    /**
     * 客户查询
     */
    @GetMapping("search")
    public PagedResult<AgencyCustomerDto> search (AgencyCustomerCriteria agencyCustomerCriteria) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyCustomerCriteria.setAgId(agId);
        return agencyCustomerQueryService.findAgencyCustomerPaged(agencyCustomerCriteria);
    }

    /**
     * 获取客户信息
     * @param id
     */
    @GetMapping("{id}")
    public TResult<AgencyCustomerDto> getInfo (@PathVariable UUID id) {
        return agencyCustomerQueryService.findAgencyCustomerBasicById(id);
    }

    /**
     * 新增客户信息
     * @param agencyCustomerDto
     * @return
     */
    @PostMapping("")
    public TResult addInfo (@RequestBody AgencyCustomerDto agencyCustomerDto) {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyCustomerDto.setAgId(agId);
        return agencyCustomerService.addOrUpdateAgencyCustomer(agencyCustomerDto);
    }

    /**
     * 修改客户信息
     * @param id
     */
    @PutMapping("{id}")
    public TResult updateInfo (@PathVariable UUID id, @RequestBody AgencyCustomerDto agencyCustomerDto) {
        agencyCustomerDto.setId(id);
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        agencyCustomerDto.setAgId(agId);
        return agencyCustomerService.addOrUpdateAgencyCustomer(agencyCustomerDto);
    }

    /**
     * 删除客户
     * @param ids
     */
    @DeleteMapping("")
    public void deleteCustomer (@RequestParam UUID... ids) {
        agencyCustomerService.deleteBatch(ids);
    }
}
