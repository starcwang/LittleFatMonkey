package com.star.monkey.wechat.robot.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.star.monkey.wechat.robot.client.dto.TuringRobotRequest;
import com.star.monkey.wechat.robot.client.dto.TuringRobotResponse;
import com.star.monkey.wechat.util.HttpClientUtil;
import com.star.monkey.wechat.util.JsonUtil;

/**
 * 图灵机器人接口调用客户端
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:36:00
 */
@Component
public class TuringRobotClient {
    private static final int READ_TIMEOUT = 6000;
    private static final int CONN_TIMEOUT = 3000;

    @Value("${turing.robot.url}")
    private String url;

    @Value("${turing.robot.key}")
    private String key;

    public TuringRobotResponse ask(String question, String location, String userId) {
        TuringRobotRequest request = new TuringRobotRequest();
        request.setKey(key);
        request.setInfo(question);
        request.setLoc(location);
        request.setUserId(userId);
        TuringRobotResponse response;
        try {
            String res = HttpClientUtil.postJson(url, JsonUtil.toJson(request), READ_TIMEOUT, CONN_TIMEOUT);
            response = JsonUtil.fromJson(res, TuringRobotResponse.class);
        } catch (Exception e) {
            response = null;
        }
        return response;
    }
}
