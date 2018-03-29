package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.MenuFunctionQueryService;
import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.admin.service.MenuFunctionService;
import com.sunesoft.ecloud.admin.service.MenuService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("menu")
public class MenuController {

    @Autowired
    MenuQueryService menuQueryService;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuFunctionQueryService functionQueryService;

    @Autowired
    MenuFunctionService menuFunctionService;

    /**
     * 菜单查询
     * @return
     */
    @GetMapping("search")
    @ResponseBody
    public ListResult<MenuSimpleDto> search () {
        return menuQueryService.findAllSimpleMenu();
    }

    /**
     * 菜单详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public TResult<MenuDto> getInfo (@PathVariable UUID id) {
        return menuQueryService.findMenuByID(id);
    }

    /**
     * 新增菜单信息
     * @param menuDto
     * @return
     */
    @PostMapping()
    @ResponseBody
    public TResult addInfo (@RequestBody MenuDto menuDto) {
       return menuService.addOrUpdateMenu(menuDto);
    }

    /**
     * 修改菜单信息
     * @param id
     * @param menuDto
     * @return
     */
    @PutMapping("{id}")
    @ResponseBody
    public TResult updateInfo (@PathVariable UUID id, @RequestBody MenuDto menuDto) {
        menuDto.setId(id);
        return menuService.addOrUpdateMenu(menuDto);
    }

    /**
     * 获取菜单操作功能
     * @param id
     */
    @GetMapping("{id}/function")
    @ResponseBody
    public ListResult<MenuFunctionDto> searchFunction (@PathVariable UUID id) {
        return functionQueryService.queryMenuFunction(id);
    }

    /**
     * 新增菜单功能
     * @param menuFunctionDto
     * @param mid
     * @return
     */
    @PostMapping("{mid}/function")
    @ResponseBody
    public TResult addFunction (@RequestBody MenuFunctionDto menuFunctionDto, @PathVariable UUID mid) {
        return menuFunctionService.addOrUpdateFunction(menuFunctionDto, mid);
    }

    /**
     * 修改菜单功能
     * @param menuFunctionDto
     * @param mid
     * @param fid
     * @return
     */
    @PutMapping("{mid}/function/{fid}")
    @ResponseBody
    public TResult updateFunction (@RequestBody MenuFunctionDto menuFunctionDto,
                                   @PathVariable UUID mid,
                                   @PathVariable UUID fid) {
        menuFunctionDto.setId(fid);
        return menuFunctionService.addOrUpdateFunction(menuFunctionDto, mid);
    }
}
