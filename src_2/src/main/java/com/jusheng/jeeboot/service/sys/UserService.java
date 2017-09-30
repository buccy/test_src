package com.jusheng.jeeboot.service.sys;

import com.jusheng.jeeboot.dao.SysUserMapper;
import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private SysUserMapper dao;

    public List<SysUser> findList(SysUser sysUser){
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if(RegexUtils.isNotEmptyIgnoreBlank(sysUser.getLoginName()))
        criteria.andEqualTo("loginName",sysUser.getLoginName());

        return dao.selectByExample(example);
    }

    public List<String> findUserPermission(SysUser sysUser){

        return null;
    }

}
