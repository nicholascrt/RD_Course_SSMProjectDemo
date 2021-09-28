package com.softeem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.dao.DepartmentDao;
import com.softeem.dto.requestDTO.DepartmentListRequestDTO;
import com.softeem.dto.requestDTO.SwitchDepartmentRequestDTO;
import com.softeem.entity.Department;
import com.softeem.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门表(Department)表服务实现类
 *
 * @author makejava
 * @since 2021-02-14 14:41:42
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depId 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer depId) {
        return this.departmentDao.queryById(depId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit) {
        return this.departmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getDepId());
    }

    /**
     * 通过主键删除数据
     *
     * @param depId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depId) {
        return this.departmentDao.deleteById(depId) > 0;
    }

    /**
     * 切换部门状态 1表示启用 2表示停用
     * @param department
     */
    @Override
    public void switchStatus(SwitchDepartmentRequestDTO department) {
        Integer status = department.getStatus();
        //1表示启用 2表示停用
        if(1==status){
            departmentDao.updateDisableStatusById(department.getDepId());
        }else{
            departmentDao.updateEnableStatusById(department.getDepId());
        }
    }

    @Override
    public Map<String,Object> queryPageList(DepartmentListRequestDTO requestDTO) {
        Map<String,Object> map = new HashMap<>();
        try {
            PageHelper.startPage(requestDTO.getPageNum(),requestDTO.getPageSize());
            Page<Department> departments = (Page) departmentDao.queryPageList(requestDTO);
            map.put("success",true);
            //转化为PageInfo传到前端来获得原生PageHelper的功能
            map.put("data",new PageInfo(departments));
        }catch (Exception e){
            map.put("success",false);
            map.put("errMsg",e.getMessage());
            return map;
        }
        return map;
    }
}