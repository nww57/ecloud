package com.sunesoft.ecloud.adminclient.cretirias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class AgencyCriteria extends TCretiria {


    /**
     * 关键字
     */
    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        if(!StringUtil.isEmpty(keywords)){
            params.put("name",keywords);
            params.put("code",keywords);
            params.put("leader",keywords);
        }
        return params;
    }


}
