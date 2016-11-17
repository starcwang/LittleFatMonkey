package com.star.monkey.wechat.service.impl;

import org.springframework.stereotype.Service;

import com.star.monkey.wechat.service.TestService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-06-04 22:44:00
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String returnSomething() {
        return "Hello World!!";
    }
}
