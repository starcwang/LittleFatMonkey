package com.star.monkey.util;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:20:00
 */
public class HttpClientUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtilTest.class);


    @Test
    public void testGet() throws Exception {
        String url = "http://www.tuling123.com/openapi/api";
        String json = "{\"key\":\"7cb5f64c88a54138bdef892c95048111\",\"info\":\"北京今天天气怎么样\"}";
        String res = HttpClientUtil.postJson(url, json, 6000);
        System.out.println(res);
        LoggerUtil.error("",JsonUtil.toJson(res));
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
        LoggerUtil.error("",json);
    }
}