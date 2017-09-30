package com.jusheng.jeeboot.entity;

import javax.persistence.*;

@Table(name = "biz_worker")
public class BizWorker extends BaseEntity {
    private String name;

    private String phone;

    private Long line;

    private Integer status;

    private String email;

    /**
     * 分区id
     */
    @Column(name = "area_id")
    private Long areaId;

    /**
     * 区域id
     */
    @Column(name = "region_id")
    private Long regionId;

    /**
     * 部门id
     */
    @Column(name = "office_id")
    private Long officeId;

    private String remark;

    @Transient
    private BizRegion bizRegion;



    public BizRegion getBizRegion() {
        return bizRegion;
    }

    public void setBizRegion(BizRegion bizRegion) {
        this.bizRegion = bizRegion;
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return line
     */
    public Long getLine() {
        return line;
    }

    /**
     * @param line
     */
    public void setLine(Long line) {
        this.line = line;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取分区id
     *
     * @return area_id - 分区id
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * 设置分区id
     *
     * @param areaId 分区id
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取区域id
     *
     * @return region_id - 区域id
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * 设置区域id
     *
     * @param regionId 区域id
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取部门id
     *
     * @return office_id - 部门id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置部门id
     *
     * @param officeId 部门id
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}