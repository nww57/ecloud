package com.sunesoft.ecloud.adminclient.cretirias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public class UserCriteria extends TCretiria {

    /**
     * 企业Id
     */
    private UUID agId;

    private String keywords;

    private String userName;

    private String realName;

    private String phoneNo;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        if(!StringUtil.isEmpty(userName)){
            params.put("userName",userName);
        }
        if(!StringUtil.isEmpty(realName)){
            params.put("realName",realName);
        }
        if(!StringUtil.isEmpty(phoneNo)){
            params.put("phoneNo",phoneNo);
        }
        return params;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
