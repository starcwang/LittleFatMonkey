package com.star.monkey.wechat.common;

/**
 * 客户端错误码
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-13 00:14:00
 */
public enum ErrorCode {
    OK(1, "成功");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
