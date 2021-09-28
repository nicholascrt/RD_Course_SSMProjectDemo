package com.softeem.dao;

import com.softeem.entity.ExpenseReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报销单表(ExpenseReport)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-24 15:24:51
 */
public interface ExpenseReportDao {

    /**
     * 通过ID查询单条数据
     *
     * @param expenseId 主键
     * @return 实例对象
     */
    ExpenseReport queryById(Integer expenseId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ExpenseReport> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param expenseReport 实例对象
     * @return 对象列表
     */
    List<ExpenseReport> queryAll(ExpenseReport expenseReport);

    /**
     * 新增数据
     *
     * @param expenseReport 实例对象
     * @return 影响行数
     */
    int insert(ExpenseReport expenseReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ExpenseReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ExpenseReport> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ExpenseReport> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ExpenseReport> entities);

    /**
     * 修改数据
     *
     * @param expenseReport 实例对象
     * @return 影响行数
     */
    int update(ExpenseReport expenseReport);

    /**
     * 通过主键删除数据
     *
     * @param expenseId 主键
     * @return 影响行数
     */
    int deleteById(Integer expenseId);

}