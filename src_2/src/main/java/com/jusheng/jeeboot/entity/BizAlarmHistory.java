package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_alarm_history")
public class BizAlarmHistory extends BaseEntity {

    @Column(name = "alarm_code")
    private String alarmCode;

    @Column(name = "box_code")
    private String boxCode;

    private Short level;

    private String content;

    @Column(name = "report_time")
    private Date reportTime;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * @return alarm_code
     */
    public String getAlarmCode() {
        return alarmCode;
    }

    /**
     * @param alarmCode
     */
    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
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
     * @return level
     */
    public Short getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Short level) {
        this.level = level;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
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