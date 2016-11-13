package com.star.monkey.robot.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.star.monkey.robot.service.WechatTokenService;
import com.star.monkey.util.SHA1;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-13 10:24:00
 */
@Service
public class WechatTokenServiceImpl implements WechatTokenService {
    @Override
    public String token(String signature, String timestamp, String nonce, String echostr) {
        String token = "lalala";
        List<String> list = Lists.newArrayList(token, timestamp, nonce);
        Collections.sort(list);
        String str = "";
        for (String s : list) {
            str += s;
        }
        String res = SHA1.encrypt(str);
        return res.equals(signature) ? echostr : "";
    }
}
