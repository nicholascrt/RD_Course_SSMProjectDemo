package com.softeem.service.impl;

import com.softeem.dao.EmployeeDao;
import com.softeem.dto.EmployeeDTO;
import com.softeem.entity.Employee;
import com.softeem.service.EmployeeService;
import com.softeem.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工表(Employee)表服务实现类
 *
 * @author makejava
 * @since 2021-01-24 15:24:51
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer emId) {
        return this.employeeDao.queryById(emId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeDao.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeDao.update(employee);
        return this.queryById(employee.getEmId());
    }

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer emId) {
        return this.employeeDao.deleteById(emId) > 0;
    }

    /**
     * 服务实现层：通过用户名和密码查询职员是否在职
     * @param userName
     * @param password
     * @return
     */
    @Override
    public EmployeeDTO getEmInfoByUsernameAndPassword(String userName, String password) {
        return employeeDao.queryEmInfoByUsernameAndPassword(userName, MD5Util.getMd5(password));
    }
}