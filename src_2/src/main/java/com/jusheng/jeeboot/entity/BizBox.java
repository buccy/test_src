package com.jusheng.jeeboot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_box")
public class BizBox extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 箱体编码
     */
    private String code;

    /**
     * 箱体名称
     */
    private String name;

    /**
     * 箱电话
     */
    private String msisdn;

    /**
     * 类型 1-自产 2-改装
     */
    private Short type;

    /**
     * 状态 0-已锁 1-已激活 2-未激活
     */
    private Short status;

    private String remark;

    /**
     * 离开时间
     */
    @Column(name = "depart_time")
    private Date departTime;

    /**
     * 归还时间
     */
    @Column(name = "back_time")
    private Date backTime;

    /**
     * 处理时间
     */
    @Column(name = "handle_time")
    private Date handleTime;

    /**
     * 负责人
     */
    @Column(name = "manager_id")
    private String managerId;

    /**
     * 线路
     */
    @Column(name = "line_id")
    private String lineId;

    @Column(name = "area_id")
    private String areaId;

    /**
     * 机构编号
     */
    @Column(name = "office_id")
    private String officeId;

    @Column(name = "region_id")
    private String regionId;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

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
     * 获取箱体编码
     *
     * @return code - 箱体编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置箱体编码
     *
     * @param code 箱体编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取箱体名称
     *
     * @return name - 箱体名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置箱体名称
     *
     * @param name 箱体名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取箱电话
     *
     * @return msisdn - 箱电话
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * 设置箱电话
     *
     * @param msisdn 箱电话
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * 获取类型 1-自产 2-改装
     *
     * @return type - 类型 1-自产 2-改装
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置类型 1-自产 2-改装
     *
     * @param type 类型 1-自产 2-改装
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取状态 0-已锁 1-已激活 2-未激活
     *
     * @return status - 状态 0-已锁 1-已激活 2-未激活
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态 0-已锁 1-已激活 2-未激活
     *
     * @param status 状态 0-已锁 1-已激活 2-未激活
     */
    public void setStatus(Short status) {
        this.status = status;
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

    /**
     * 获取离开时间
     *
     * @return depart_time - 离开时间
     */
    public Date getDepartTime() {
        return departTime;
    }

    /**
     * 设置离开时间
     *
     * @param departTime 离开时间
     */
    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    /**
     * 获取归还时间
     *
     * @return back_time - 归还时间
     */
    public Date getBackTime() {
        return backTime;
    }

    /**
     * 设置归还时间
     *
     * @param backTime 归还时间
     */
    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    /**
     * 获取处理时间
     *
     * @return handle_time - 处理时间
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * 设置处理时间
     *
     * @param handleTime 处理时间
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * 获取负责人
     *
     * @return manager_id - 负责人
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * 设置负责人
     *
     * @param managerId 负责人
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    /**
     * 获取线路
     *
     * @return line_id - 线路
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * 设置线路
     *
     * @param lineId 线路
     */
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    /**
     * @return area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(String areaId) {
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
     * @return region_id
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}