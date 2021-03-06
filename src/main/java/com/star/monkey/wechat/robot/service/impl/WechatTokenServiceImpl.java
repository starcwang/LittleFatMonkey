package com.star.monkey.wechat.robot.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.star.monkey.wechat.robot.service.WechatTokenService;
import com.star.monkey.wechat.util.SHA1Util;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-13 10:24:00
 */
@Service
public class WechatTokenServiceImpl implements WechatTokenService {
    @Override
    public String authToken(String signature, String timestamp, String nonce, String echostr) {
        String token = "lalala";
        List<String> list = Lists.newArrayList(token, timestamp, nonce);
        Collections.sort(list);
        String str = "";
        for (String s : list) {
            str += s;
        }
        String res = SHA1Util.encrypt(str);
        return res.equals(signature) ? echostr : "";
    }
}
