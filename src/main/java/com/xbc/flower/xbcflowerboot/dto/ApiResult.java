package com.xbc.flower.xbcflowerboot.dto;


import com.xbc.cloud.xbcsystem.dto.status.StatusCode;
import com.xbc.cloud.xbcsystem.dto.status.enums.StatusEnum;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author xbcRaisins
 * @date 2019/2/21 13:31
 */
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 4315496618973196429L;

    private Integer code;
    private String message;
    private T data;
    private String innerMsg;

    private ApiResult() {
        this(StatusEnum.OK);
    }

    public ApiResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public ApiResult(StatusCode statusCode, String message) {
        this(statusCode);
        if (message != null) {
            this.message = message;
        }
    }

    public ApiResult(T data) {
        this();
        this.data = data;
        this.message = "";
    }

    public ApiResult(T data, String message) {
        this();
        this.data = data;
        if (message != null) {
            this.message = message;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public void setData(T data) {
        this.data = data;
    }

    public String getInnerMsg() {
        return innerMsg;
    }

    public void setInnerMsg(String innerMsg) {
        this.innerMsg = innerMsg;
    }

    @Override
    public String toString() {
        return "status=" + code + ",message=" + message + ",data=" + data + "innerMsg=" + innerMsg;
    }
}
