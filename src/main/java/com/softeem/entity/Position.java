package com.softeem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 职位表(Position)实体类
 *
 * @author makejava
 * @since 2021-01-24 15:24:53
 */
public class Position implements Serializable {
    private static final long serialVersionUID = 853533650511711784L;
    /**
     * 职位表id
     */
    private Integer positionId;
    /**
     * 职位名
     */
    private String positionName;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}