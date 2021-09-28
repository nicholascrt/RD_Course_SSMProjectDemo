package com.softeem.dto;

import com.softeem.entity.Department;
import com.softeem.entity.Position;

import java.io.Serializable;

/**
 * @project_name: com.softeem.dto
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 26/01/2021 1:06 AM
 * @version: v1.0
 */
public class EmployeeDTO implements Serializable{

    private static final long serialVersionUID = 7028515937091490879L;
    /**
     * 员工id
     */
    private Integer emId;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 用户名
     */
    private String loginName;
    /**
     * 部门id
     */
    private Integer depId;
    /**
     * 职位id
     */
    private Integer positionId;
    /**
     * 状态(0:离职 1:在职)
     */
    private Integer status;
    /**
     * 关联的部门信息
     */
    private Department department;
    /**
     * 关联的职位信息
     */
    private Position position;

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "emId=" + emId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", depId=" + depId +
                ", positionId=" + positionId +
                ", status=" + status +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
