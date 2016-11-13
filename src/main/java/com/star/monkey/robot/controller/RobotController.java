package com.star.monkey.robot.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.star.monkey.robot.model.response.Response;
import com.star.monkey.robot.service.RobotAskService;
import com.star.monkey.robot.service.WechatTokenService;

/**
 * 图灵机器人调用接口类<br/>
 * <a href="http://www.tuling123.com">图灵机器人地址<a/>
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 21:47:00
 */
@Controller
@RequestMapping("/robot")
public class RobotController {
    @Resource
    private RobotAskService robotAskService;

    @Resource
    private WechatTokenService wechatTokenService;

    /**
     * 微信token验证接口
     */
    @RequestMapping("/token")
    @ResponseBody
    public String token(String signature, String timestamp, String nonce, String echostr) {
        return wechatTokenService.token(signature, timestamp, nonce, echostr);
    }

    /**
     * 图灵机器人对话接口
     */
    @RequestMapping("/ask")
    @ResponseBody
    public Response ask(String question) {
        return Response.success().setData(robotAskService.ask(question));
    }
}
