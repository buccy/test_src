package com.jusheng.jeeboot.entity;

import javax.persistence.*;

@Table(name = "sys_param")
public class SysParam extends BaseEntity{
    /**
     * 名字
     */
    private String name;

    /**
     * 值
     */
    private String value;

    private String type;

    private String desription;

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
    }

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
     * @return desription
     */
    public String getDesription() {
        return desription;
    }

    /**
     * @param desription
     */
    public void setDesription(String desription) {
        this.desription = desription;
    }
}