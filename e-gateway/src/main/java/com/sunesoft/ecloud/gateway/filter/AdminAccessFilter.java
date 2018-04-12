package com.sunesoft.ecloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sunesoft.ecloud.adminclient.clientService.AuthServiceClient;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.responseMsg.NoAuthorityResponse;
import com.sunesoft.ecloud.common.responseMsg.TokenErrorResponse;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.utils.JsonHelper;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.auth.configs.UserAuthConfig;
import com.sunesoft.ecloud.auth.jwt.JwtTokenUtil;
import com.sunesoft.ecloud.auth.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
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


    @Autowired
    AuthServiceClient authServiceClient;

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

        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();
        UserContext.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            return null;
        }
        JwtUser jwtUser;
        try {
            jwtUser = getJWTUser(request, ctx);
        } catch (Exception e) {
            setFailedRequest(JsonHelper.toJson(new TokenErrorResponse(e.getMessage())), 200);
            return null;
        }
        ListResult<MenuFunctionDto> functionDtos = authServiceClient.getFunctions(jwtUser.getId().toString());
        if (functionDtos.getIs_success() && functionDtos.getResult() != null && functionDtos.getResult().size() > 0) {
            checkFunctions(requestUri, method, functionDtos.getResult());
        } else {
            setFailedRequest(JsonHelper.toJson(new NoAuthorityResponse("no Authentication!")), 200);
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
     * 获取目标权限资源
     *
     * @param requestUri
     * @param method
     * @param serviceInfo
     * @return
     */
    private Boolean checkFunctions(final String requestUri, final String method, List<MenuFunctionDto> serviceInfo) {
        Stream<MenuFunctionDto> result = serviceInfo.parallelStream().filter(new Predicate<MenuFunctionDto>() {
            @Override
            public boolean test(MenuFunctionDto permissionInfo) {
                String url = permissionInfo.getResUrl();
                String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
                String regEx = "^" + uri + "$";
                return (Pattern.compile(regEx).matcher(requestUri).find() || requestUri.startsWith(url + "/"))
                        && method.equals(permissionInfo.getResRequestType().toString());
            }
        });

        if (result.count() == 0) {
            setFailedRequest(JsonHelper.toJson(new NoAuthorityResponse("no Authentication!")), 200);
        }
        return true;
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

    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }
}
