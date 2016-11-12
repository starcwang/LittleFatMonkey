package com.star.littlefatmonkey.service.impl;

import org.springframework.stereotype.Service;

import com.star.littlefatmonkey.service.TestService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-06-04 22:44:00
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String returnSomething() {
        return "Hello World!!";
    }
}
