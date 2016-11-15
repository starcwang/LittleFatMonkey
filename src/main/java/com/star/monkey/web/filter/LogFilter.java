package com.star.monkey.web.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.star.monkey.manager.LogManager;
import com.star.monkey.util.JsonUtil;
import com.star.monkey.util.LoggerUtil;


/**
 * 日志
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 20:58:00
 */
public class LogFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        initLog(httpReq);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void initLog(HttpServletRequest httpReq) {
        LogManager.init();
        String traceId = httpReq.getParameter("traceId");
        if (StringUtils.isBlank(traceId)) {
            traceId = UUID.randomUUID().toString();
        }
        String ip = httpReq.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip)) {
            ip = httpReq.getRemoteAddr();
        }
        LogManager.setTraceId(traceId, httpReq.getRequestURI(), ip);
    }
}
