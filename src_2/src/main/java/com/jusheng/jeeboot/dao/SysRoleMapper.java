package com.jusheng.jeeboot.dao;

import com.jusheng.jeeboot.entity.SysRole;
import com.jusheng.jeeboot.system.BaseMapper;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> findList(SysRole sysRole);
}