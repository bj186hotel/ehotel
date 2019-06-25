package com.bj186.ssm.controller;

import com.bj186.ssm.entity.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 郑金城
 * @title: BaseController
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/2510:16
 */
public class BaseController {
    @ResponseBody
    @ExceptionHandler
    public Map<String,Object> baseControllerException(HttpServletRequest request, Exception ex){
        Map<String,Object> stringObjectMap=new HashMap<>();
        if(ex instanceof MyException){
            MyException jsonException= (MyException) ex;
            stringObjectMap.put("code",jsonException.getCode());
            stringObjectMap.put("msg",jsonException.getMsg());
        }else{
            stringObjectMap.put("code","-200");
            stringObjectMap.put("msg","系统繁忙");
        }
        return  stringObjectMap;
    }
}
