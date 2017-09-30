package com.jusheng.jeeboot.system.config;

import com.jusheng.jeeboot.system.security.CredentialsMatcher;
import com.jusheng.jeeboot.system.filter.SysFilter;
import com.jusheng.jeeboot.utils.LogUtils;
import com.jusheng.jeeboot.system.security.ShiroAuthRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;

/**
 * shiro的配置类
 * @author Administrator
 *
 */
@Configuration
public class ShiroConfig {

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/home");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/getCaptcha", "anon"); //获取验证码
        filterChainDefinitionMap.put("/getPublicKey", "anon");//获取公钥
        filterChainDefinitionMap.put("/demo/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/api/**", "anon");//开发周期暂不校验权限
        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return bean;
    }

    @Bean(name="sysFilter")
    public SysFilter sysFilter(@Qualifier("shiroFilter") ShiroFilterFactoryBean shiroFilterFactoryBean) {
        SysFilter sysFilter=new SysFilter();
        shiroFilterFactoryBean.getFilters().put("sys",sysFilter);
        return sysFilter;
    }

    //配置核心安全事务管理器
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("shiroAuthRealm") ShiroAuthRealm shiroAuthRealm) {
        LogUtils.logger.info("--------------loading shiro--------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(shiroAuthRealm);
        return manager;
    }
    //配置自定义的权限登录器
    @Bean(name="shiroAuthRealm")
    public ShiroAuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
        ShiroAuthRealm shiroAuthRealm=new ShiroAuthRealm();
        shiroAuthRealm.setCredentialsMatcher(matcher);
        return shiroAuthRealm;
    }
    //配置自定义的密码比较器
    @Bean(name="credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}