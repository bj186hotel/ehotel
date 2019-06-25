package com.bj186.ssm.entity;

/**
 * @author 郑金城
 * @title: MyException
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/259:37
 */
public class MyException extends Exception {
    private String code;
    private String msg;

    public MyException(String code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
