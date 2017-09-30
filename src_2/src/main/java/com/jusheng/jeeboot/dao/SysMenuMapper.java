package com.jusheng.jeeboot.dao;

import com.jusheng.jeeboot.entity.SysMenu;
import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.system.BaseMapper;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<Map<String,Object>> findCurrentUserMenu(SysUser sysUser);
}