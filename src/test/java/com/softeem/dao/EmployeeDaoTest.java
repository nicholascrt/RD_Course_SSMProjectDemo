package com.softeem.dao;

import com.softeem.dto.EmployeeDTO;
import com.softeem.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @project_name: com.softeem.dao
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 26/01/2021 2:02 AM
 * @version: v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //指定静态资源的路径，因为Spring和Swagger都有容器，会产生冲突
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void queryEmInfoByUsernameAndPassword() {
        EmployeeDTO employeeDTO = employeeDao.queryEmInfoByUsernameAndPassword("13100000001", MD5Util.getMd5("123456"));
        System.out.println(employeeDTO);
    }
}