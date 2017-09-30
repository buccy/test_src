package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_notify")
public class BizNotify extends BaseEntity{

    private String type;

    private String level;

    private String title;

    private String content;

    @Column(name = "worker_ids")
    private String workerIds;

    /**
     * 通知时间
     */
    @Column(name = "notify_time")
    private Date notifyTime;

    /**
     * 通知方式 0-短信，1-邮件,多种方式格式: 0,1
     */
    @Column(name = "notify_way")
    private String notifyWay;

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return worker_ids
     */
    public String getWorkerIds() {
        return workerIds;
    }

    /**
     * @param workerIds
     */
    public void setWorkerIds(String workerIds) {
        this.workerIds = workerIds;
    }

    /**
     * 获取通知时间
     *
     * @return notify_time - 通知时间
     */
    public Date getNotifyTime() {
        return notifyTime;
    }

    /**
     * 设置通知时间
     *
     * @param notifyTime 通知时间
     */
    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    /**
     * 获取通知方式 0-短信，1-邮件,多种方式格式: 0,1
     *
     * @return notify_way - 通知方式 0-短信，1-邮件,多种方式格式: 0,1
     */
    public String getNotifyWay() {
        return notifyWay;
    }

    /**
     * 设置通知方式 0-短信，1-邮件,多种方式格式: 0,1
     *
     * @param notifyWay 通知方式 0-短信，1-邮件,多种方式格式: 0,1
     */
    public void setNotifyWay(String notifyWay) {
        this.notifyWay = notifyWay;
    }
}