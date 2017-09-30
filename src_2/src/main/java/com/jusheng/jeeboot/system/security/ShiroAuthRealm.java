package com.jusheng.jeeboot.system.security;

import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.service.sys.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * Shiro密码认证和授权的地方
 */
public class ShiroAuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    void ShiroAuthRealm(){
    }

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        SysUser sysUserCon=new SysUser();
        sysUserCon.setLoginName(username);
        List<SysUser> list= userService.findList(sysUserCon);
        if (list.size()<=0){
            return null;
        }

        SysUser sysUser=list.get(0);
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SysUser sysUser=(SysUser) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();

//        Set<Role> roles = sysUser.getRoles();
//        if(roles.size()>0) {
//            for(Role role : roles) {
//                Set<Module> modules = role.getModules();
//                if(modules.size()>0) {
//                    for(Module module : modules) {
//                        permissions.add(module.getMname());
//                    }
//                }
//            }
//        }

        permissions.add("yes");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}
