package com.bj186.ssm.controller;

import com.bj186.ssm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 郑金城
 * @title: UserController
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/1010:28
 */
/*@Controller
@RequestMapping("user")//http://localhost:8080/usser   user就会找到注解中标注为user的controller类*/
public class User2Controller {
   /* //http://localhost:8080/user/login login就会找到requestmappring标注为login的方法
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        System.out.println("访问到这儿了");
        System.out.println(user);
        HttpSession session = request.getSession(true);
        session.setAttribute("username",user.getCustomerName());
        //返回值表示视图，web-inf/jsp/user/login.jsp
        return user;
    }*/
}
