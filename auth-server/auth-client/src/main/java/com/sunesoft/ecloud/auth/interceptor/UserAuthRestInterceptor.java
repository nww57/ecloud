package com.sunesoft.ecloud.auth.interceptor;

import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.auth.annotation.IgnoreUserToken;
import com.sunesoft.ecloud.auth.exeption.AgencyNotFoundException;
import com.sunesoft.ecloud.auth.exeption.TokenNotFoundException;
import com.sunesoft.ecloud.auth.jwt.JwtTokenUtil;
import com.sunesoft.ecloud.auth.jwt.JwtUser;
import com.sunesoft.ecloud.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ace on 2017/9/10.
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);

    @Value("${jwt.header}")
    private String tokenHeader;



    @Value("${path.ignore.startWith}")
    private String startWith;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 配置该注解，说明不进行用户拦截
        IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
        }
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }
        if ("OPTIONS".equals(request.getMethod())) {//这里通过判断请求的方法，判断此次是否是预检请求，如果是，立即返回一个204状态吗，标示，允许跨域；预检后，正式请求，这个方法参数就是我们设置的post了
            return super.preHandle(request, response, handler);

        }
        String contextPath = request.getContextPath();
        String requstUri = request.getRequestURI();
        if(contextPath!=null&&contextPath.equals("/")){
            requstUri=request.getRequestURI().substring(request.getContextPath().length());
        }
        if(isStartWith(requstUri)){
            return super.preHandle(request, response, handler);
        }
            String token = request.getHeader(tokenHeader);
        if (StringUtil.isEmpty(token)) {
         throw new TokenNotFoundException("TokenNotFound");
        }

        JwtUser infoFromToken = jwtTokenUtil.getInfoFromToken(token);
        if(infoFromToken.getAgencyid()==null){
            throw new AgencyNotFoundException("AgencyNotFound");

        }
        UserContext.setUsername(infoFromToken.getUsername());
        UserContext.setRealName(infoFromToken.getRealname());
        UserContext.setUserID(infoFromToken.getId());
        UserContext.setAgencyId(infoFromToken.getAgencyid());
        return super.preHandle(request, response, handler);
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

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
