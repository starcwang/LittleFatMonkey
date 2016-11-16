package com.star.monkey.robot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.star.monkey.robot.model.request.WechatRequest;
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
     * 用于微信接口验证
     */
    @RequestMapping("/token")
    @ResponseBody
    @Deprecated
    public String token(String signature, String timestamp, String nonce, String echostr) {
        return wechatTokenService.authToken(signature, timestamp, nonce, echostr);
    }

    /**
     * 图灵机器人对话接口
     */
    @RequestMapping("/ask")
    @ResponseBody
    public WechatRequest ask(@RequestBody WechatRequest wechatRequest, String signature, String timestamp, String nonce, String echostr) {
        return robotAskService.ask(wechatRequest);
//        return "success";
//        return Response.success().setData(robotAskService.ask(question)).toString();
    }
}
