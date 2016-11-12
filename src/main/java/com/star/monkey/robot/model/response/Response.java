package com.star.monkey.robot.model.response;

import com.star.monkey.common.ErrorCode;
import com.star.monkey.util.JsonUtil;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-11-13 00:10:00
 */
public class Response<T>  {
    private int code;
    private String message;
    private T data;

    private Response() {

    }

    private Response(ErrorCode errorCode) {
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <D>Response<D> success() {
        return new Response<D>(ErrorCode.OK);
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
