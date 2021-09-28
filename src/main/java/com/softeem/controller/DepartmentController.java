package com.softeem.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.dto.requestDTO.DepartmentListRequestDTO;
import com.softeem.dto.requestDTO.SwitchDepartmentRequestDTO;
import com.softeem.entity.Department;
import com.softeem.service.DepartmentService;
import com.softeem.utils.HttpServletRequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project_name: com.softeem.controller
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 13/02/2021 8:38 PM
 * @version: v1.0
 */
@Api(tags = "部门管理模块")
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController{

    @Autowired
    DepartmentService departmentService;

    /**
     * 跳转到部门列表的路由
     * @return
     */
    @GetMapping("/toList")
    public String toList(){
        request.getSession().setAttribute("pageTitle","部门列表");
        return "departmentList";
    }

    /**
     * 跳转到部门修改页面
     * @return
     */
    @ApiOperation(value = "跳转到部门修改页面")
    @GetMapping("/toDepartmentEdit")
    public String toDepartmentEdit(){
        return "departmentEdit";
    }

    /**
     * 跳转到部门修改页面
     * @return
     */
    @ApiOperation(value = "跳转到部门信息查看页面")
    @GetMapping("/toDepartmentView")
    public String toDepartmentView(){
        return "departmentView";
    }

    /*
     * @Description 查询部门列表
     *                  1. 分页查询
     *                  2. 模糊查询
     * @Date 2:03 AM 19/02/2021
     * @Param
     * @return
     */
    @PostMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody DepartmentListRequestDTO departmentListRequestDTO){
        Map<String,Object> map = new HashMap<>();
        try{
            map = departmentService.queryPageList(departmentListRequestDTO);
        }catch (Exception e){
            map.put("success",false);
            map.put("errMsg",e.getMessage());
            return map;
        }
        return map;
    }

    /**
     * 跳转到新增部门页面的路由
     * @return
     */
    @ApiOperation(value = "跳转到新增部门页面")
    @GetMapping("/toDepartmentAdd")
    public String toDepartmentAdd(){
        request.getSession().setAttribute("pageTitle","新增部门");
        return "departmentAdd";
    }

    /**
     * 新增部门Department
     * @return
     */
    @PostMapping("/insertDepartment")
    @ResponseBody
    @ApiOperation(value = "部门新增接口")
    public Map<String,Object> insertDepartment(HttpServletRequest request){
        //检测调用的request service
        if(request instanceof HttpServletRequest){
            System.out.println("自动装配的request:HttpServletRequest");
        }
        //在参数中主动请求的HttpServletRequest会是MultipartHttpServletRequest
        if(request instanceof MultipartHttpServletRequest){
            System.out.println("自动装配的request:MultipartHttpServletRequest");
        }
        Map<String,Object> map = new HashMap<>();
        //调用departmentService,插入生成的department
        try{
            String departmentStr = HttpServletRequestUtil.getString(request, "departmentStr");
            Department department;
            try{
                //利用Jackson工具转换json字符串为对象
                ObjectMapper mapper = new ObjectMapper();
                department = mapper.readValue(departmentStr,Department.class);
            }catch (JacksonException je){
                map.put("success",false);
                map.put("errorMsg",je.getMessage());
                return map;
            }
            departmentService.insert(department);
        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg",e.getMessage());
            return map;
        }
        map.put("success",true);
        return map;
    }

    /**
     * 部门Department状态切换（启用 / 停用）
     * @return
     */
    @ApiOperation(value = "单个部门状态切换")
    @PostMapping("/switchDepartmentStatus")
    @ResponseBody
    public Map<String,Object> switchDepartmentStatus(@RequestBody SwitchDepartmentRequestDTO requestDTO){
        Map<String,Object> map = new HashMap<>();
        /**
         * 方法1: 在Service层根据当前部门状态调用不同方法修改部门状态(复用性高)
         * 方法2: 在mapper.xml写动态sql(复用性低)
         */
        try{
            departmentService.switchStatus(requestDTO);
        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg",e.getMessage());
            return map;
        }
        map.put("success",true);
        return map;
//        //旧方法
//        //前端传来的需要修改状态的部门信息的json字符串
//        String departmentStr = HttpServletRequestUtil.getString(request,"departmentStr");
//        //转化json为对象
//        ObjectMapper mapper = new ObjectMapper();
//        Department department = null;
//
//        //用ObjectMapper方法来根据json生成对应Department的对象
//        try {
//            department = mapper.readValue(departmentStr,Department.class);
//            System.out.println(department);
//        }catch (Exception e){
//            map.put("success",false);
//            map.put("errorMsg",e.getMessage());
//            return map;
//        }
    }

    /**
     * 根据主键id获得部门
     * @return
     */
    @PostMapping("/queryDepartmentById")
    @ResponseBody
    public Map<String,Object> queryDepartmentById(){
        Map<String,Object> map = new HashMap<>();
        Department department = null;

        //前端传来的id
        int id = HttpServletRequestUtil.getInt(request,"departmentStr");
        try{
            department = departmentService.queryById(id);
        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg",e.getMessage());
        }
        map.put("success",true);
        map.put("data",department);
        return map;
    }
}
