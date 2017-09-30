package com.jusheng.jeeboot.system;

import com.jusheng.jeeboot.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by Administrator on 2017/9/25.
 */
public class LoginedUser {
    /**
     * 获取当前登录的用户
     * @return
     */
    public static SysUser getCurrentUser(){
        Subject subject=SecurityUtils.getSubject();
        return (SysUser)subject.getPrincipal();
    }
}
