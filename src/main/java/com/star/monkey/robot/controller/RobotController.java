package com.star.monkey.robot.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.star.monkey.robot.model.request.WechatRequest;
import com.star.monkey.robot.model.response.Response;
import com.star.monkey.robot.service.RobotAskService;
import com.star.monkey.robot.service.WechatTokenService;
import com.star.monkey.util.JsonUtil;
import com.star.monkey.util.LoggerUtil;

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
    private static final Logger logger = LoggerFactory.getLogger(RobotController.class);

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
    public String ask(@RequestBody WechatRequest wechatRequest, HttpServletRequest request) {
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String, String> reqMap = Maps.newHashMap();
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                Object element = enumeration.nextElement();
                if (element != null) {
                    String paramName = (String) element;
                    String paramValue = request.getParameter(paramName);
                    reqMap.put(paramName.toLowerCase(), paramValue);
                }
            }
        }
        LoggerUtil.info("logId_wechatRequest", JsonUtil.toJson(wechatRequest));
        LoggerUtil.info("logId_reqMap", JsonUtil.toJson(reqMap));
        LoggerUtil.info("logId_request", JsonUtil.toJson(reqMap));

        return "<xml><ToUserName>wc760823254</ToUserName><FromUserName>小胖猴猴</FromUserName><CreateTime>1460541339</CreateTime><MsgType>text</MsgType><Content>hello world</Content></xml>";
//        return wechatTokenService.token(signature, timestamp, nonce, echostr);
//        return Response.success().setData(robotAskService.ask(question)).toString();
    }
}
