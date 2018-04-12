package com.sunesoft.ecloud.common.responseMsg;

import com.sunesoft.ecloud.common.constants.RestCodeConstants;
import com.sunesoft.ecloud.common.result.TResult;

public class TokenForbiddenResponse  extends TResult {
    public TokenForbiddenResponse(String message) {
        super( message, RestCodeConstants.TOKEN_FORBIDDEN_CODE);
    }
}