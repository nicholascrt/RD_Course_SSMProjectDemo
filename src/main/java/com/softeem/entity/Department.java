package com.softeem.entity;

import java.io.Serializable;

/**
 * 部门表(Department)实体类
 *
 * @author makejava
 * @since 2021-02-14 14:40:49
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 108640030139122182L;
    /**
     * 部门id
     */
    private Integer depId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 办公地点
     */
    private String address;
    /**
     * 状态1:启用 2:停用
     */
    private Integer status;


    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}