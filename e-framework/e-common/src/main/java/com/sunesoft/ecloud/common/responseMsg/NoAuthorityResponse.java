package com.sunesoft.ecloud.common.responseMsg;

import com.sunesoft.ecloud.common.constants.RestCodeConstants;
import com.sunesoft.ecloud.common.result.TResult;

public class NoAuthorityResponse extends TResult {
    public NoAuthorityResponse(String message) {
        super( message, RestCodeConstants.TOKEN_NO_AUTHORITY);
    }
}