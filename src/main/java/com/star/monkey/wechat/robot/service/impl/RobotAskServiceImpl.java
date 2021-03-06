package com.star.monkey.wechat.robot.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.star.monkey.wechat.robot.client.TuringRobotClient;
import com.star.monkey.wechat.robot.client.dto.TuringRobotResponse;
import com.star.monkey.wechat.robot.common.enums.WechatMsgType;
import com.star.monkey.wechat.model.request.WechatRequest;
import com.star.monkey.wechat.robot.service.RobotAskService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:29:00
 */
@Service
public class RobotAskServiceImpl implements RobotAskService {
    @Resource
    private TuringRobotClient turingRobotClient;

    @Override
    public WechatRequest ask(WechatRequest wechatRequest) {
        WechatRequest response = new WechatRequest();
        TuringRobotResponse turingRobotResponse = turingRobotClient.ask(wechatRequest.getContent(), StringUtils.EMPTY, wechatRequest.getFromUserName());
        response.setCreateTime(System.currentTimeMillis());
        response.setMsgType(WechatMsgType.text.name());
        response.setFromUserName(wechatRequest.getToUserName());
        response.setToUserName(wechatRequest.getFromUserName());
        if (StringUtils.isNotBlank(turingRobotResponse.getUrl())) {
            response.setContent(turingRobotResponse.getText() + "\n" + turingRobotResponse.getUrl());
        } else {
            response.setContent(turingRobotResponse.getText());
        }
        return response;
    }
}
