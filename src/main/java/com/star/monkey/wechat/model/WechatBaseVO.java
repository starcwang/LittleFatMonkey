package com.star.monkey.wechat.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-16 19:46:00
 */
public abstract class WechatBaseVO {
    /**
     * 消息接收人用户名
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;
    /**
     * 消息发送人用户名
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间
     * linux时间戳
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;
    /**
     * 消息类型
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#name
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 消息唯一id
     */
    @XmlElement(name = "MsgId")
    private Long msgId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
