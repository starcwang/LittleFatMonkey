package com.star.monkey.wechat.robot.client.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * 图灵机器人 接口请求参数描述类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:43:00
 */
public class TuringRobotResponse {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 回复内容
     */
    private String text;
    /**
     * 链接地址
     */
    private String url;
    /**
     * 回复数据内容
     */
    private List<Detail> list;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Detail> getList() {
        return list;
    }

    public void setList(List<Detail> list) {
        this.list = list;
    }

    /**
     * 新闻描述类
     */
    public static class News extends Detail {
        /**
         * 新闻标题
         */
        private String article;
        /**
         * 新闻来源
         */
        private String source;

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

    /**
     * 菜谱描述类
     */
    public static class Cookbook extends Detail {
        /**
         * 菜名
         */
        private String name;
        /**
         * 介绍
         */
        private String info;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 返回结果描述抽象类
     */
    public static abstract class Detail {
        /**
         * 详细地址url
         */
        @JsonProperty("detailurl")
        private String detailUrl;
        /**
         * 图标
         */
        private String icon;

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
