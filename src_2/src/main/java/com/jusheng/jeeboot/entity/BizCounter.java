package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_counter")
public class BizCounter extends BaseEntity{

    /**
     * 指标编码 
     */
    private String code;

    /**
     * 值类型
     */
    @Column(name = "value_type")
    private Short valueType;

    /**
     * 单元
     */
    private String unit;

    /**
     * 周期
     */
    private Integer period;

    /**
     * 标题
     */
    private String title;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "current_value")
    private String currentValue;

    @Column(name = "collect_time")
    private Date collectTime;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 获取指标编码 
     *
     * @return code - 指标编码 
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置指标编码 
     *
     * @param code 指标编码 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取值类型
     *
     * @return value_type - 值类型
     */
    public Short getValueType() {
        return valueType;
    }

    /**
     * 设置值类型
     *
     * @param valueType 值类型
     */
    public void setValueType(Short valueType) {
        this.valueType = valueType;
    }

    /**
     * 获取单元
     *
     * @return unit - 单元
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单元
     *
     * @param unit 单元
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取周期
     *
     * @return period - 周期
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 设置周期
     *
     * @param period 周期
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return current_value
     */
    public String getCurrentValue() {
        return currentValue;
    }

    /**
     * @param currentValue
     */
    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
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