package com.bj186.ssm.entity;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郑金城
 * @title: MyExceptionResolver
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/259:35
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MyException myException = null;
        if(e instanceof MyException){
            myException = (MyException)e;
        }else {
            myException = new MyException("未知异常");
        }
        return null;
    }
}
