package com.star.monkey.robot.client.dto;


import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 图灵机器人 接口请求参数描述类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-12 23:40:00
 */
public class TuringRobotRequest {
    /**
     * key=7cb5f64c88a54138bdef892c95048111
     */
    private String key;
    /**
     * 用户问题
     */
    private String info;
    /**
     * 用户id，用来标示唯一用户
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * 用户地理信息
     */
    private String loc;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
