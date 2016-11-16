package com.star.monkey.client;

import java.text.MessageFormat;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.base.Optional;
import com.star.monkey.util.HttpClientUtil;
import com.star.monkey.util.JsonUtil;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-16 11:54:00
 */
@Component
public class WechatAccessTokenClient {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type={0}&appid={1}&secret={2}";
    private static final String GRANT_TYPE = "client_credential";
    private static final String APPID = "wxfea702381faefc29";
    private static final String SECRET = "5a119ffcae2ff2a0ad1bac7ebb336c09";

    public String getAccessToken() {
        String resJson = HttpClientUtil.get(MessageFormat.format(URL, GRANT_TYPE, APPID, SECRET));
        Map<String, Object> resMap = JsonUtil.toMap(resJson);
        return Optional.fromNullable(resMap.get(ACCESS_TOKEN)).or("").toString();
    }
}
