package com.star.monkey.wechat.robot.service;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-13 10:23:00
 */
public interface WechatTokenService {
    String authToken(String signature, String timestamp, String nonce, String echostr);
}
