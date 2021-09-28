package com.softeem.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @project_name: com.softeem.dto
 * @description: 分页信息
 * @author: Nicholas Chen
 * @time: 24/02/2021 11:58 PM
 * @version: v1.0
 */
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 546125947779828553L;

    @ApiModelProperty(value = "页码，从1开始")
    private int pageNum = 1;//页码，从1开始
    @ApiModelProperty(value = "页面大小")
    private int pageSize = 10;//页面大小
    @ApiModelProperty(value = "总数")
    private long total;//总数
    @ApiModelProperty(value = "总页数")
    private long pages;//总页数

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
