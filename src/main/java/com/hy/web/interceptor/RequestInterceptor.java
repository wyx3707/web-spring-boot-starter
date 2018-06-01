package com.hy.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Request拦截器配置（用于检查是否是合法的请求）
 *
 * @author wyx
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private ThreadLocal<Long> requestTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        System.out.println("[Request URL ] :" + requestURI);
        System.out.println("[ParameterMap ] :" + parameterMap);
        requestTime.set(System.currentTimeMillis());
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        Long beginTime = requestTime.get();
        long endTime = System.currentTimeMillis();
        System.out.println("Session end, execute time: " + (endTime - beginTime) + "ms");
    }
}
