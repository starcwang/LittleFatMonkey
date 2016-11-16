package com.star.monkey.robot.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.star.monkey.robot.model.WechatBaseVO;

/**
 * 微信请求和返回描述类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-15 20:14:00
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatRequest extends WechatBaseVO {
    /**
     * 消息内容
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#text
     */
    @XmlElement(name = "Content")
    private String content;
    /**
     * 图片消息url
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#image
     */
    @XmlElement(name = "PicUrl")
    private String picUrl;
    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#image
     * @see com.star.monkey.robot.common.enums.WechatMsgType#voice
     * @see com.star.monkey.robot.common.enums.WechatMsgType#video
     * @see com.star.monkey.robot.common.enums.WechatMsgType#shortvideo
     */
    @XmlElement(name = "MediaId")
    private String mediaId;
    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#voice
     */
    @XmlElement(name = "Format")
    private String format;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#video
     */
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;
    /**
     * 地理位置纬度
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#location
     */
    @XmlElement(name = "Location_X")
    private Double locationX;
    /**
     * 地理位置经度
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#location
     */
    @XmlElement(name = "Location_Y")
    private Double locationY;
    /**
     * 地图缩放大小
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#location
     */
    @XmlElement(name = "Scale")
    private Integer scale;
    /**
     * 地理位置信息
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#location
     */
    @XmlElement(name = "Label")
    private String label;
    /**
     * 消息标题
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#link
     */
    @XmlElement(name = "Title")
    private String title;
    /**
     * 消息描述
     *
     * @see com.star.monkey.robot.common.enums.WechatMsgType#link
     */
    @XmlElement(name = "Description")
    private String description;
    /**
     * 消息链接
     *;
     * @see com.star.monkey.robot.common.enums.WechatMsgType#image
     * @see com.star.monkey.robot.common.enums.WechatMsgType#link
     */
    @XmlElement(name = "Url")
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
