package com.softeem.service.impl;

import com.softeem.entity.Department;
import com.softeem.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @project_name: com.softeem.service.impl
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 25/02/2021 1:05 AM
 * @version: v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //指定静态资源的路径，因为Spring和Swagger都有容器，会产生冲突
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

//    @Test
//    public void insert() {
//        for (int i = 1; i < 500; i++) {
//            Department department = new Department();
//            department.setName("测试部门名"+i);
//            department.setAddress("测试部门地址"+i);
//            department.setStatus(2);
//            departmentService.insert(department);
//        }
//    }
}