package com.star.monkey.robot.client;

import org.springframework.stereotype.Component;

import com.star.monkey.robot.client.dto.TuringRobotRequest;
import com.star.monkey.robot.client.dto.TuringRobotResponse;
import com.star.monkey.util.HttpClientUtil;
import com.star.monkey.util.JsonUtil;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:36:00
 */
@Component
public class TuringRobotClient {
    private static final int READ_TIMEOUT = 6000;
    private static final int CONN_TIMEOUT = 3000;
    private static final String URL = "http://www.tuling123.com/openapi/api";
    private static final String KEY = "7cb5f64c88a54138bdef892c95048111";

    public TuringRobotResponse ask(String question, String location, String userId) {
        TuringRobotRequest request = new TuringRobotRequest();
        request.setKey(KEY);
        request.setInfo(question);
        request.setLoc(location);
        request.setUserId(userId);
        TuringRobotResponse response;
        try {
            String res = HttpClientUtil.postJson(URL, JsonUtil.toJson(request), READ_TIMEOUT, CONN_TIMEOUT);
            response = JsonUtil.fromJson(res, TuringRobotResponse.class);
        } catch (Exception e) {
            response = null;
        }
        return response;
    }
}
