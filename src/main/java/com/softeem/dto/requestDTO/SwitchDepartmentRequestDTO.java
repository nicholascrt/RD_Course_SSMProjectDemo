package com.softeem.dto.requestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @project_name: com.softeem.dto.requestDTO
 * @description: @todo
 * @author: Nicholas Chen
 * @time: 23/02/2021 9:59 PM
 * @version: v1.0
 */
@ApiModel(description = "切换单个部门状态RequestDTO")
public class SwitchDepartmentRequestDTO implements Serializable {

    private static final long serialVersionUID = -8495691339140050195L;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id",example = "1")
    private Integer depId;

    /**
     * 状态1:启用 2:停用
     */
    @ApiModelProperty(value = "状态1:启用 2:停用",example = "1")
    private Integer status;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
