package com.softeem.controller;

import com.softeem.dao.EmployeeDao;
import com.softeem.dto.EmployeeDTO;
import com.softeem.dto.requestDTO.LoginRequestDTO;
import com.softeem.service.EmployeeService;
import com.softeem.utils.HttpServletRequestUtil;
import com.softeem.utils.VerificationCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @project_name: com.softeem.controller
 * @description: 路由控制器 Controller
 * @author: Nicholas Chen
 * @time: 24/01/2021 4:30 PM
 * @version: v1.0
 */

/**
 * @Api注解放在请求的类上，用来说明类的作用
 */
@Api(tags = "登录登出模块")
@Controller
public class IndexController extends BaseController{

    @Autowired
    private EmployeeService employeeService;

    /*
     * @Description login登录路由
     * @Date 4:37 PM 24/01/2021
     * @return java.lang.String
     */
    @ApiOperation(value = "登录", notes = "后台登录", httpMethod = "get", response = String.class)
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * @Description @ResponseBody为了用ajax请求
     *              默认的content-type:application/x-www-form-urlencoded
     * @Date 5:17 PM 24/01/2021
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @ApiOperation(value = "验证登录",notes = "验证用户名和密码是否存在与数据库")
    @PostMapping("checkLogin")
    @ResponseBody
    //用了@RequestBody 接收json后，最好不要单独设定属性
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="userName",value = "用户名",required = false,defaultValue = "默认13100000001",example = "131")
//    })
//    public Map<String,Object> checkLogin(HttpServletRequest request, @RequestParam String userName,@RequestParam String password){
    //用@RequestBody来接收json字符串
    public Map<String,Object> checkLogin(@RequestBody LoginRequestDTO loginRequestDTO){
        Map<String,Object> map = new HashMap<>();
//        //获取输入的用户名
//        String userName = HttpServletRequestUtil.getString(request,"userName");
        String userName = loginRequestDTO.getUserName();
//        //获取输入的密码
//        String password = HttpServletRequestUtil.getString(request,"password");
        String password = loginRequestDTO.getPassword();
        /** 获取输入的验证码
         *  1. 判断是否需要验证码校验
         *  2. 获取用户输入的验证码
         *  3. 对比验证码是否输入正确
         */
        boolean needVerify = loginRequestDTO.getNeedVerify();
        if(needVerify && !VerificationCodeUtil.checkVerificationCode(request,loginRequestDTO.getVerificationCode())){
            map.put("success",false);
            map.put("errMsg","验证码输入错误");
            return map;
        }
        //非空校验
        if(userName != null && password != null){
            //通过用户名和密码去查数据库
            EmployeeDTO employeeDTO = employeeService.getEmInfoByUsernameAndPassword(userName, password);
            if(null != employeeDTO){
                map.put("success",true);
                //如果查到就将用户信息存进Session
                request.getSession().setAttribute("user",employeeDTO);
            }else{
                map.put("success",false);
                map.put("errMsg","帐号密码错误或该用户已离职");
            }
        }else{
            map.put("success",false);
            map.put("errMsg","帐号密码不能为空");
        }
        return map;
    }

    /**
     * 主页路由
     * @return
     */
    @GetMapping("/main")
    public String mainPage(){
        request.getSession().setAttribute("pageTitle","待处理报销单");
        return "main";
    }

    /**
     * 登出
     * @return
     */
    @PostMapping("/logout")
    @ResponseBody
    public Map<String,Object> logout(){
        Map<String,Object> map = new HashMap<>();
        //将session清空
        request.getSession().setAttribute("user",null);
        request.getSession().setAttribute("pageTitle",null);
        map.put("success",true);
        return map;
    }
}
