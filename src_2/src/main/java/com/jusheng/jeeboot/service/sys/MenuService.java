package com.jusheng.jeeboot.service.sys;

import com.jusheng.jeeboot.dao.SysMenuMapper;
import com.jusheng.jeeboot.dao.SysUserMapper;
import com.jusheng.jeeboot.entity.SysMenu;
import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;


@Service
public class MenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    public List<Map<String,Object>> findCurrentUserMenu(SysUser sysUser){
        return sysMenuMapper.findCurrentUserMenu(sysUser);
    }
}
