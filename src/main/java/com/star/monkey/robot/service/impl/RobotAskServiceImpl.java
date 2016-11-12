package com.star.monkey.robot.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.star.monkey.robot.client.TuringRobotClient;
import com.star.monkey.robot.client.dto.TuringRobotResponse;
import com.star.monkey.robot.model.pojo.RobotAnswer;
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
    public RobotAnswer ask(String question) {
        RobotAnswer response = new RobotAnswer();
        TuringRobotResponse turingRobotResponse = turingRobotClient.ask(question, StringUtils.EMPTY, StringUtils.EMPTY);
        response.setAnswer(turingRobotResponse.getText());
        return response;
    }
}
