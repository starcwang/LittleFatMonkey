package com.star.monkey.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.star.monkey.manager.LogManager;
import com.star.monkey.util.LoggerUtil;

/**
 * Controller层异常切面
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class ControllerExceptionAop implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = "";
        try {
            result = invocation.proceed();
        } catch (Exception e) {
            LoggerUtil.error(LogManager.getUri() + "_unknown_error", e.getMessage(), e);
        }
        return result;
    }
}
