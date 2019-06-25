package com.bj186.ssm.entity;

import org.apache.shiro.authc.*;
/**
 * @author 郑金城
 * @title: UsernamePasswordByUserTypeToken 自定义带用户类型token继承UsernamePasswordToken
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/2412:28
 */
public class UsernamePasswordByUserTypeToken extends UsernamePasswordToken  {
    //定义用户类型用来多用户shiro判断
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UsernamePasswordByUserTypeToken(String username, String password, String userType) {
        super(username, password);
        this.userType = userType;
    }
}
