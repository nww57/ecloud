package com.sunesoft.ecloud.adminclient.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: niww
 * @Date: 2018/4/17/017
 * Feign配置，传递token
 */
public class FeignConfigInterceptor implements RequestInterceptor{

    @Value("${jwt.header}")
    private String tokenHeader;
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(tokenHeader, getHeaders(getHttpServletRequest()).get(tokenHeader));
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
