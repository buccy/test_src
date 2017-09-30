package com.jusheng.jeeboot.entity;

import javax.persistence.*;

@Table(name = "biz_line")
public class BizLine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String code;

    private String name;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "back_time")
    private Integer backTime;

    private Integer status;

    @Column(name = "area_id")
    private Long areaId;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    private String remark;

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
     * @return manager_id
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * @return region_id
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /**
     * @return back_time
     */
    public Integer getBackTime() {
        return backTime;
    }

    /**
     * @param backTime
     */
    public void setBackTime(Integer backTime) {
        this.backTime = backTime;
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
     * @return area_id
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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