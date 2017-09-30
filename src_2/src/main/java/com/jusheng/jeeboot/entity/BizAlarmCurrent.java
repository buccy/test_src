package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_alarm_current")
public class BizAlarmCurrent extends BaseEntity {

    /**
     * 报警编码
     */
    @Column(name = "alarm_code")
    private String alarmCode;

    /**
     * 箱体编码
     */
    @Column(name = "box_code")
    private String boxCode;

    /**
     * 报警级别
     */
    private Short level;

    /**
     * 报警内容
     */
    private String content;

    @Column(name = "report_time")
    private Date reportTime;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 获取报警编码
     *
     * @return alarm_code - 报警编码
     */
    public String getAlarmCode() {
        return alarmCode;
    }

    /**
     * 设置报警编码
     *
     * @param alarmCode 报警编码
     */
    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    /**
     * 获取箱体编码
     *
     * @return box_code - 箱体编码
     */
    public String getBoxCode() {
        return boxCode;
    }

    /**
     * 设置箱体编码
     *
     * @param boxCode 箱体编码
     */
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    /**
     * 获取报警级别
     *
     * @return level - 报警级别
     */
    public Short getLevel() {
        return level;
    }

    /**
     * 设置报警级别
     *
     * @param level 报警级别
     */
    public void setLevel(Short level) {
        this.level = level;
    }

    /**
     * 获取报警内容
     *
     * @return content - 报警内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置报警内容
     *
     * @param content 报警内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return report_time
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * @param reportTime
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
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