package com.softeem.dao;

import com.softeem.entity.ExpenseReportDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报销单细节表(ExpenseReportDetail)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-24 15:24:52
 */
public interface ExpenseReportDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param expensiveDetailId 主键
     * @return 实例对象
     */
    ExpenseReportDetail queryById(Integer expensiveDetailId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ExpenseReportDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param expenseReportDetail 实例对象
     * @return 对象列表
     */
    List<ExpenseReportDetail> queryAll(ExpenseReportDetail expenseReportDetail);

    /**
     * 新增数据
     *
     * @param expenseReportDetail 实例对象
     * @return 影响行数
     */
    int insert(ExpenseReportDetail expenseReportDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ExpenseReportDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ExpenseReportDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ExpenseReportDetail> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ExpenseReportDetail> entities);

    /**
     * 修改数据
     *
     * @param expenseReportDetail 实例对象
     * @return 影响行数
     */
    int update(ExpenseReportDetail expenseReportDetail);

    /**
     * 通过主键删除数据
     *
     * @param expensiveDetailId 主键
     * @return 影响行数
     */
    int deleteById(Integer expensiveDetailId);

}