package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_open_log")
public class BizOpenLog extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "time_limit")
    private Integer timeLimit;

    @Column(name = "log_time")
    private Date logTime;

    @Column(name = "box_code")
    private String boxCode;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 区域
     */
    @Column(name = "region_id")
    private String regionId;

    /**
     * 分区
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 线路
     */
    @Column(name = "line_id")
    private String lineId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return time_limit
     */
    public Integer getTimeLimit() {
        return timeLimit;
    }

    /**
     * @param timeLimit
     */
    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    /**
     * @return log_time
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * @param logTime
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * @return box_code
     */
    public String getBoxCode() {
        return boxCode;
    }

    /**
     * @param boxCode
     */
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    /**
     * 获取机构编号
     *
     * @return office_id - 机构编号
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * 设置机构编号
     *
     * @param officeId 机构编号
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取区域
     *
     * @return region_id - 区域
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * 设置区域
     *
     * @param regionId 区域
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取分区
     *
     * @return area_id - 分区
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置分区
     *
     * @param areaId 分区
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取线路
     *
     * @return line_id - 线路
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * 设置线路
     *
     * @param lineId 线路
     */
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
}