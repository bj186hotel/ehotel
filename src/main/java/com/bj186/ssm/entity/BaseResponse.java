package com.bj186.ssm.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 郑金城
 * @title: BaseResponse
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/2511:22
 */
public class BaseResponse {
    private Object data;
    private String code;
    private String msg;

    public BaseResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
