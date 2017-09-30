package com.jusheng.jeeboot.entity;

import javax.persistence.*;

@Table(name = "biz_region")
public class BizRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    /**
     * 员工id
     */
    @Column(name = "worker_id")
    private Long workerId;

    /**
     * 状态 0-无效 1-有效
     */
    private Short status;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取员工id
     *
     * @return worker_id - 员工id
     */
    public Long getWorkerId() {
        return workerId;
    }

    /**
     * 设置员工id
     *
     * @param workerId 员工id
     */
    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    /**
     * 获取状态 0-无效 1-有效
     *
     * @return status - 状态 0-无效 1-有效
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态 0-无效 1-有效
     *
     * @param status 状态 0-无效 1-有效
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}