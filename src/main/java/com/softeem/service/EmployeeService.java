package com.softeem.service;

import com.softeem.dto.EmployeeDTO;
import com.softeem.entity.Employee;

import java.util.List;

/**
 * 员工表(Employee)表服务接口
 *
 * @author makejava
 * @since 2021-01-24 15:24:51
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    Employee queryById(Integer emId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer emId);

    /*
     * @Description 通过用户名和密码查询职员是否在职
     * @Date 1:05 AM 26/01/2021
     * @Param [userName用户名, password密码]
     * @return void
     */
    EmployeeDTO getEmInfoByUsernameAndPassword(String userName, String password);
}