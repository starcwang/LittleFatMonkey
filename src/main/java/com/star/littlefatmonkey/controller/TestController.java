package com.star.littlefatmonkey.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.star.littlefatmonkey.service.TestService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since  2016-06-04 22:41:00
 */
@Controller
@RequestMapping("/main")
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public String selectAllCars() {
        return testService.returnSomething();
    }
}
