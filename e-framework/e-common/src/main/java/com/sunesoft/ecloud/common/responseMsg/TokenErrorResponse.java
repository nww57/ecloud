package com.sunesoft.ecloud.common.responseMsg;

import com.sunesoft.ecloud.common.constants.RestCodeConstants;
import com.sunesoft.ecloud.common.result.TResult;

public class TokenErrorResponse extends TResult {
    public TokenErrorResponse(String message) {
        super( message, RestCodeConstants.TOKEN_ERROR_CODE);
    }
}