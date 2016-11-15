package com.star.monkey.robot.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.star.monkey.robot.client.TuringRobotClient;
import com.star.monkey.robot.client.dto.TuringRobotResponse;
import com.star.monkey.robot.common.enums.WechatMsgType;
import com.star.monkey.robot.model.request.WechatViewVO;
import com.star.monkey.robot.service.RobotAskService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:29:00
 */
@Service
public class RobotAskServiceImpl implements RobotAskService {
    @Resource
    private TuringRobotClient turingRobotClient;

    @Override
    public WechatViewVO ask(WechatViewVO wechatRequest) {
        WechatViewVO response = new WechatViewVO();
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
