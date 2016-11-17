package com.star.monkey.wechat.client;

import java.text.MessageFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;
import com.star.monkey.wechat.util.HttpClientUtil;
import com.star.monkey.wechat.util.JsonUtil;

/**
 * 调用微信获取access_token
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-16 11:54:00
 */
@Component
public class WechatAccessTokenClient {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String GRANT_TYPE = "client_credential";
    private static final String APP_ID = "wxfea702381faefc29";
    private static final String SECRET = "5a119ffcae2ff2a0ad1bac7ebb336c09";

    @Value("${wechat.access.token.url}?grant_type={0}&appid={1}&secret={2}")
    private String url;

    public String getAccessToken() {
        String resJson = HttpClientUtil.get(MessageFormat.format(url, GRANT_TYPE, APP_ID, SECRET));
        Map<String, Object> resMap = JsonUtil.toMap(resJson);
        return Optional.fromNullable(resMap.get(ACCESS_TOKEN)).or("").toString();
    }
}
