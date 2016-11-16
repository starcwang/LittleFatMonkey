package com.star.monkey.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 22:54:00
 */
public class HttpClientUtil {
    private static final int READ_TIMEOUT = 6000;
    private static final int CONN_TIMEOUT = 3000;
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String get(String url, int connTimeOut) {
        return get(url, null, connTimeOut, READ_TIMEOUT);
    }

    public static String get(String url) {
        return get(url, null, CONN_TIMEOUT, READ_TIMEOUT);
    }

    public static String get(String url, Map<String, String> params, int connTimeOut, int soTimeout) {
        String result = null;
        if (params != null && params.size() > 0) {
            String param = genGetParam(params);
            url = StringUtils.contains(url, "?") ? url + "&" + param : url + "?" + param;
        }
        HttpGet get = new HttpGet(url);
        get.setConfig(RequestConfig.custom()
                .setConnectTimeout(connTimeOut)
                .setSocketTimeout(soTimeout)
                .build());
        HttpEntity entity = null;
        try {
            CloseableHttpResponse response = HttpClientBuilder.create().build().execute(get);
            entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            EntityUtils.consumeQuietly(entity);
        }

        return result;
    }

    public static String postJson(String url, String contents, int connTimeOut) {
        return post(url, contents, connTimeOut, "application/json");
    }

    public static String postJson(String url, String contents, int connTimeOut, int soTimeout) {
        return post(url, contents, connTimeOut, "application/json", soTimeout);
    }

    public static String postEncodedForm(String url, String contents, int connTimeOut) {
        return post(url, contents, connTimeOut, "application/x-www-form-urlencoded");
    }

    public static String postEncodedForm(String url, String contents, int connTimeOut, int soTimeout) {
        return post(url, contents, connTimeOut, "application/x-www-form-urlencoded", soTimeout);
    }

    public static String post(String url, String contents, int connTimeOut, String mediaType) {
        return post(url, contents, connTimeOut, mediaType, CONN_TIMEOUT);
    }

    public static String post(String url, String contents, int connTimeOut, String mediaType, int soTimeout) {
        String result = null;

        HttpPost post = new HttpPost(url);
        post.setConfig(RequestConfig.custom()
                .setConnectTimeout(connTimeOut)
                .setSocketTimeout(soTimeout)
                .build());
        post.setEntity(new StringEntity(contents, ContentType.create(mediaType, DEFAULT_CHARSET)));
        HttpEntity entity = null;
        try {
            CloseableHttpResponse response = HttpClientBuilder.create().build().execute(post);
            entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            EntityUtils.consumeQuietly(entity);
        }

        return result;
    }

    public static String postEncodedForm(String url, List<NameValuePair> params, int connTimeOut) {
        return postEncodedForm(url, params, connTimeOut, true);
    }

    public static String postEncodedForm(String url, List<NameValuePair> params, int connTimeOut, boolean addTraceId) {
        return postEncodedForm(url, params, connTimeOut, CONN_TIMEOUT);
    }

    public static String postEncodedForm(String url, List<NameValuePair> params, int connTimeOut, int soTimeout) {
        String result = null;

        HttpPost post = new HttpPost(url);
        post.setConfig(RequestConfig.custom()
                .setConnectTimeout(connTimeOut)
                .setSocketTimeout(soTimeout)
                .build());
        HttpEntity entity = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(params, DEFAULT_CHARSET));
            CloseableHttpResponse response = HttpClientBuilder.create().build().execute(post);
            entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            EntityUtils.consumeQuietly(entity);
        }

        return result;
    }

    public static String postMap(String url, Map<String, String> params, int connTimeOut) {
        return postMap(url, params, connTimeOut, READ_TIMEOUT);
    }

    public static String postMap(String url, Map<String, String> params, int connTimeOut, int soTimeout) {
        List<NameValuePair> pairs = new LinkedList<NameValuePair>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        return postEncodedForm(url, pairs, connTimeOut, soTimeout);
    }

    private static String genGetParam(Map<String, String> params) {
        List<String> paramTmp = new ArrayList<String>();
        for (Entry<String, String> entry : params.entrySet()) {
            try {
                paramTmp.add(URLEncoder.encode(entry.getKey(), DEFAULT_CHARSET) + "=" + URLEncoder.encode(entry.getKey(), DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException ignored) {
            }
        }
        return StringUtils.join(paramTmp, "&");
    }
}
