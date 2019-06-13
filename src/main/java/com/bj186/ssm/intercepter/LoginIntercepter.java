package com.bj186.ssm.intercepter;

/**
 * @author 郑金城
 * @title: LoginIntercepter
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/1111:33
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        String requestURI = request.getRequestURI();
        if(requestURI.indexOf("/login")<=0){
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if(username!=null){
                //登陆成功的用户
                return true;
            }else{
                //没有登陆，转向登陆界面
               // request.getRequestDispatcher("../view/Login.jsp").forward(request,response);
                response.sendRedirect("/static/index.html");
                return false;
            }
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
