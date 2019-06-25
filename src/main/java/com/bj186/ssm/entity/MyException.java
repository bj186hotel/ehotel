package com.bj186.ssm.entity;

/**
 * @author 郑金城
 * @title: MyException
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/259:37
 */
public class MyException extends Exception {
    private String msg;

    public MyException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
