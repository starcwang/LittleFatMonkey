package com.star.monkey.wechat.robot.service;

import com.star.monkey.wechat.model.request.WechatRequest;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:29:00
 */
public interface RobotAskService {
    WechatRequest ask(WechatRequest wechatRequest);
}
