package com.softeem.dto.requestDTO;

import com.softeem.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @project_name: com.softeem.dto.requestDTO
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 19/02/2021 4:19 PM
 * @version: v1.0
 */
@ApiModel(description = "获取部门列表RequestDTO")
public class DepartmentListRequestDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 2131699323094381064L;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称",example = "")
    private String name;

    /**
     * 办公地点
     */
    @ApiModelProperty(value = "地址",example = "")
    private String address;

    /**
     * 状态1:启用 2:停用
     */
    @ApiModelProperty(value = "状态1:启用 2:停用",example = "")
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

