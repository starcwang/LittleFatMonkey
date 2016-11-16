package com.star.monkey.client;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-16 12:13:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring.xml")
public class WechatAccessTokenClientTest {
    @Resource
    private WechatAccessTokenClient wechatAccessTokenClient;

    @Test
    public void getAccessToken() throws Exception {
        System.out.println(wechatAccessTokenClient.getAccessToken());
    }

}