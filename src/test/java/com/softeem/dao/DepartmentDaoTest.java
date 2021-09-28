package com.softeem.dao;

import com.softeem.dto.requestDTO.DepartmentListRequestDTO;
import com.softeem.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @project_name: com.softeem.dao
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 19/02/2021 2:11 AM
 * @version: v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //指定静态资源的路径，因为Spring和Swagger都有容器，会产生冲突
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void queryPageList() {
        DepartmentListRequestDTO requestDTO = new DepartmentListRequestDTO();
        requestDTO.setName("测试部门名");
        requestDTO.setAddress("测试地址");
        List<Department> departments = departmentDao.queryPageList(requestDTO);
    }
}