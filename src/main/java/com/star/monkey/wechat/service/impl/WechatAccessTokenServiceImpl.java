package com.star.monkey.wechat.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.star.monkey.wechat.client.WechatAccessTokenClient;
import com.star.monkey.wechat.service.WechatAccessTokenService;
import com.star.monkey.wechat.util.LoggerUtil;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-16 10:33:00
 */
@Service
public class WechatAccessTokenServiceImpl implements WechatAccessTokenService, InitializingBean {
    private static final String ACCESS_TOKEN = "accessToken";
    private static final long ACCESS_TOKEN_OUT_MINUTE = 100L;

    @Resource
    private WechatAccessTokenClient wechatAccessTokenClient;

    private LoadingCache<String, String> guavaAccessTokenCache;

    @Override
    public String getAccessToken() {
        try {
            return guavaAccessTokenCache.get(ACCESS_TOKEN);
        } catch (ExecutionException e) {
            LoggerUtil.error("access_token_service_error", "获取accessToken失败", e);
            return StringUtils.EMPTY;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        guavaAccessTokenCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(ACCESS_TOKEN_OUT_MINUTE, TimeUnit.MINUTES)  // 自动刷新时间
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return wechatAccessTokenClient.getAccessToken();
                    }
                });
    }
}
