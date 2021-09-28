package com.softeem.controller;

import com.softeem.entity.Department;
import com.softeem.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @project_name: com.softeem.controller
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 14/02/2021 5:59 PM
 * @version: v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentControllerTest {

    @Autowired
    DepartmentService departmentService;

    @Test
    public void insertDepartment() {
        Department department = new Department();
        departmentService.insert(department);
    }

    @Test
    public void switchDepartmentStatus() {
    }

    @Test
    public void queryDepartmentById() {
    }
}