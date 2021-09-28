package com.softeem.service.impl;

import com.softeem.dao.ExpenseReportDao;
import com.softeem.entity.ExpenseReport;
import com.softeem.service.ExpenseReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报销单表(ExpenseReport)表服务实现类
 *
 * @author makejava
 * @since 2021-01-24 15:24:52
 */
@Service("expenseReportService")
public class ExpenseReportServiceImpl implements ExpenseReportService {
    @Resource
    private ExpenseReportDao expenseReportDao;

    /**
     * 通过ID查询单条数据
     *
     * @param expenseId 主键
     * @return 实例对象
     */
    @Override
    public ExpenseReport queryById(Integer expenseId) {
        return this.expenseReportDao.queryById(expenseId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ExpenseReport> queryAllByLimit(int offset, int limit) {
        return this.expenseReportDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param expenseReport 实例对象
     * @return 实例对象
     */
    @Override
    public ExpenseReport insert(ExpenseReport expenseReport) {
        this.expenseReportDao.insert(expenseReport);
        return expenseReport;
    }

    /**
     * 修改数据
     *
     * @param expenseReport 实例对象
     * @return 实例对象
     */
    @Override
    public ExpenseReport update(ExpenseReport expenseReport) {
        this.expenseReportDao.update(expenseReport);
        return this.queryById(expenseReport.getExpenseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param expenseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer expenseId) {
        return this.expenseReportDao.deleteById(expenseId) > 0;
    }
}