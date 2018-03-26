package com.sunesoft.ecloud.core.auth.interceptor;


import com.sunesoft.ecloud.core.auth.CommonConstants;
import com.sunesoft.ecloud.core.auth.UserContext;
import com.sunesoft.ecloud.core.auth.config.ServiceAuthConfig;
import com.sunesoft.ecloud.core.auth.config.UserAuthConfig;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author: Zhouzh
 * @Date: 2018/3/24
 */
@Component
public class OkHttpTokenInterceptor implements Interceptor {

    @Autowired
    @Lazy
    private UserAuthConfig userAuthConfig;


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = null;
        if (chain.request().url().toString().contains("client/token")) {
            newRequest = chain.request()
                    .newBuilder()
                    .header(userAuthConfig.getTokenHeader(), UserContext.getToken())
                    .build();
        } else {
            newRequest = chain.request()
                    .newBuilder()
                    .header(userAuthConfig.getTokenHeader(), UserContext.getToken())
                     .build();
        }
        Response response = chain.proceed(newRequest);
        return response;
    }
}
