package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_counter_history")
public class BizCounterHistory extends BaseEntity{

    @Column(name = "counter_code")
    private String counterCode;

    @Column(name = "box_code")
    private String boxCode;

    private String value;

    @Column(name = "collect_time")
    private Date collectTime;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * @return counter_code
     */
    public String getCounterCode() {
        return counterCode;
    }

    /**
     * @param counterCode
     */
    public void setCounterCode(String counterCode) {
        this.counterCode = counterCode;
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
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return collect_time
     */
    public Date getCollectTime() {
        return collectTime;
    }

    /**
     * @param collectTime
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