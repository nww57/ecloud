package com.sunesoft.ecloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.auth.configs.UserAuthConfig;
import com.sunesoft.ecloud.auth.jwt.JwtTokenUtil;
import com.sunesoft.ecloud.auth.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zhouzh
 * @create 2018-04-08 8:25
 */
@Component
public class AdminAccessFilter extends ZuulFilter {
    @Value("${jwt.header}")
    private String tokenHeader;


    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Value("${zuul.prefix}")
    private String zuulPrefix;



    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        JwtUser jwtUser;
//        try {
//              jwtUser = getJWTUser(request,ctx);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();
        UserContext.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            return null;
        }


        return null;
    }
    /**
     * 返回session中的用户信息
     *
     * @param request
     * @param ctx
     * @return
     */
    private JwtUser getJWTUser(HttpServletRequest request, RequestContext ctx) throws Exception {
        String authToken = request.getHeader(tokenHeader);
        if (StringUtil.isEmpty(authToken)) {
            authToken = request.getParameter("token");
        }
        if (authToken != null && authToken.startsWith("Bearer "))
            authToken = authToken.substring(7);

        ctx.addZuulRequestHeader(tokenHeader, authToken);
        UserContext.setToken(authToken);
        return jwtTokenUtil.getInfoFromToken(authToken);
    }

    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }
}
