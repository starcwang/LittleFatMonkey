package com.star.monkey.robot.service;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-13 10:23:00
 */
public interface WechatTokenService {
    String token(String signature, String timestamp, String nonce, String echostr);
}
