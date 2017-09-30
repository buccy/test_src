package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_counter_current")
public class BizCounterCurrent extends BaseEntity{
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 指标代码
     */
    @Column(name = "counter_code")
    private String counterCode;

    /**
     * 箱体代码
     */
    @Column(name = "box_code")
    private String boxCode;

    /**
     * 值
     */
    private String value;

    /**
     * 采集时间
     */
    @Column(name = "collect_time")
    private Date collectTime;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 获取指标代码
     *
     * @return counter_code - 指标代码
     */
    public String getCounterCode() {
        return counterCode;
    }

    /**
     * 设置指标代码
     *
     * @param counterCode 指标代码
     */
    public void setCounterCode(String counterCode) {
        this.counterCode = counterCode;
    }

    /**
     * 获取箱体代码
     *
     * @return box_code - 箱体代码
     */
    public String getBoxCode() {
        return boxCode;
    }

    /**
     * 设置箱体代码
     *
     * @param boxCode 箱体代码
     */
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取采集时间
     *
     * @return collect_time - 采集时间
     */
    public Date getCollectTime() {
        return collectTime;
    }

    /**
     * 设置采集时间
     *
     * @param collectTime 采集时间
     */
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
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
}