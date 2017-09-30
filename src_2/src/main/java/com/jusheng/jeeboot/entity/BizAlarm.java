package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_alarm")
public class BizAlarm extends BaseEntity {

    /**
     * 报警号
     */
    private String code;

    /**
     * 类型 1-系统 2-业务 3-通讯
     */
    private Short type;

    /**
     * 级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     */
    private Short level;

    /**
     * 原因
     */
    private String reason;

    /**
     * 处理预案
     */
    private String suggestion;

    /**
     * 标题
     */
    private String title;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 0-未激活 1-已激活
     */
    private Short status;

    /**
     * 最后一次上报的时间
     */
    @Column(name = "last_report_time")
    private Date lastReportTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 处理期限
     */
    @Column(name = "handle_time_limit")
    private Integer handleTimeLimit;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 获取报警号
     *
     * @return code - 报警号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置报警号
     *
     * @param code 报警号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取类型 1-系统 2-业务 3-通讯
     *
     * @return type - 类型 1-系统 2-业务 3-通讯
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置类型 1-系统 2-业务 3-通讯
     *
     * @param type 类型 1-系统 2-业务 3-通讯
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     *
     * @return level - 级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     */
    public Short getLevel() {
        return level;
    }

    /**
     * 设置级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     *
     * @param level 级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     */
    public void setLevel(Short level) {
        this.level = level;
    }

    /**
     * 获取原因
     *
     * @return reason - 原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置原因
     *
     * @param reason 原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取处理预案
     *
     * @return suggestion - 处理预案
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * 设置处理预案
     *
     * @param suggestion 处理预案
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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
     * 获取状态 0-未激活 1-已激活
     *
     * @return status - 状态 0-未激活 1-已激活
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态 0-未激活 1-已激活
     *
     * @param status 状态 0-未激活 1-已激活
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取最后一次上报的时间
     *
     * @return last_report_time - 最后一次上报的时间
     */
    public Date getLastReportTime() {
        return lastReportTime;
    }

    /**
     * 设置最后一次上报的时间
     *
     * @param lastReportTime 最后一次上报的时间
     */
    public void setLastReportTime(Date lastReportTime) {
        this.lastReportTime = lastReportTime;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取处理期限
     *
     * @return handle_time_limit - 处理期限
     */
    public Integer getHandleTimeLimit() {
        return handleTimeLimit;
    }

    /**
     * 设置处理期限
     *
     * @param handleTimeLimit 处理期限
     */
    public void setHandleTimeLimit(Integer handleTimeLimit) {
        this.handleTimeLimit = handleTimeLimit;
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