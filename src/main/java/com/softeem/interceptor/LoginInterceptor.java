package com.softeem.interceptor;

import com.softeem.dto.EmployeeDTO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @project_name: 登录拦截器
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 27/01/2021 2:48 AM
 * @version: v1.0
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        //从Session里面查询是否有user对象
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            //如果用户信息不为null,则吧session中的用户信息转换成EmployeeDTO实体对象
            EmployeeDTO userInfo = (EmployeeDTO)user;
            //空值以及有效判断(必须在职)
            if(null != userInfo && userInfo.getEmId() != null && userInfo.getStatus()==1){ 
                //当Session user已经存在（表示已登录）时，访问/login or / 应该直接跳转到main页面
                if(request.getRequestURI().toLowerCase().indexOf("login")>=0
                    || "/".equals(request.getRequestURI())){
                    response.sendRedirect("/main");
                    return false;
                }
                return true;
            }
        }
        if(request.getRequestURI().toLowerCase().indexOf("login")>=0
                || "/".equals(request.getRequestURI())){
            return true;
        }
        //如果不满足登录验证的条件，就调到登录页面
        response.sendRedirect("/login");
        return false;
    }
}
