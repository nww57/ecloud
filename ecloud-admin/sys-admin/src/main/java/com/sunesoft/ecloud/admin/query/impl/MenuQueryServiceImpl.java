package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午8:14
 * -
 */
public class MenuQueryServiceImpl implements MenuQueryService {

    @Autowired
    MenuRepository menuRepository;


    @Override
    public TResult queryMenu() {
        return null;
    }
}
