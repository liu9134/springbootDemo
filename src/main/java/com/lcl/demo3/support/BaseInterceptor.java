package com.lcl.demo3.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/17 13:59
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        logger.debug("请求路径" + uri);
        return true;
    }
}
