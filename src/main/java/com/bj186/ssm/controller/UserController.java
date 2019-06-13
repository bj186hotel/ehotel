package com.bj186.ssm.controller;

import com.bj186.ssm.pojo.User;
import com.bj186.ssm.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author 郑金城
 * @title: UserController
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/1010:28
 */
@Controller
@RequestMapping("user")//http://localhost:8080/usser   user就会找到注解中标注为user的controller类
public class UserController {
    @Resource(name = "userService")
    private UserServiceImpl userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String register(@RequestBody(required = false) User user){
        System.out.println("user"+user);
        userService.register(user);
        return "";
    }

    public String register2(@RequestBody(required = false) User user){
        System.out.println("user"+user);
        userService.register(user);
        return "";
    }
}
