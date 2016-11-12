package com.star.monkey.robot.service;

import com.star.monkey.robot.model.pojo.RobotAnswer;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:29:00
 */
public interface RobotAskService {
    RobotAnswer ask(String question);
}
