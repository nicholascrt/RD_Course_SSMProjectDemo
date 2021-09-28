package com.softeem.dao;

import com.softeem.dto.EmployeeDTO;
import com.softeem.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工表(Employee)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-24 15:24:51
 */
public interface EmployeeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    Employee queryById(Integer emId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    List<Employee> queryAll(Employee employee);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int insert(Employee employee);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employee> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Employee> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employee> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Employee> entities);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 影响行数
     */
    int deleteById(Integer emId);

    /**
     * DAO访问层：通过用户名和密码查询职员是否在职
     * @param userName
     * @param password
     * @return
     */
    EmployeeDTO queryEmInfoByUsernameAndPassword(@Param("userName") String userName,@Param("password") String password);
}