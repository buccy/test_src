package com.jusheng.jeeboot.web.demo;



import com.jusheng.jeeboot.dao.BizWorkerMapper;
import com.jusheng.jeeboot.entity.BizWorker;
import com.jusheng.jeeboot.utils.JsonUtils;
import com.jusheng.jeeboot.utils.LogUtils;
import com.jusheng.jeeboot.utils.RSAUtils;
import com.jusheng.jeeboot.utils.RegexUtils;
import com.jusheng.jeeboot.web.BaseController;
import com.jusheng.jeeboot.entity.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.*;

import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.jusheng.jeeboot.service.sys.UserService;

/**
 * Created by Administrator on 2017/9/6.
 */
@Controller
@RequestMapping("demo")
public class DemoController extends BaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    private BizWorkerMapper bizWorkerMapper;

    @RequestMapping("hello/{v1}/{username}/{password}")
    String hello(@PathVariable String username, @PathVariable String password){
        return "hello";
    }

    private String message = "Hello World";

    //Freemarker
    @RequestMapping("freemarker")
    String welcome(ModelMap model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "hello";
    }

    //JDBC
    @RequestMapping("jdbc")
    @ResponseBody
    String jdbc(){
        String sql = "SELECT 1 from dual";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    //国际化测试
    @RequestMapping("i18n")
    String i18n(ModelMap model,Locale locale) {
        String tmp=messageSource.getMessage("demo.test.message", null, locale);
        model.addAttribute("message", tmp);
        return "i18n";
    }

    //测试日志
    @RequestMapping("log4j")
    @ResponseBody
    String log4j(){
        LogUtils.logger.error("this is a error msg");
        return "";
    }

    //测试RSA公私钥
    @RequestMapping("publicKey")
    @ResponseBody
    String publicKey(){
            Map<String,byte[]> map= RSAUtils.generateKeyBytes();
            byte[] pub=(byte [])map.get(RSAUtils.PUBLIC_KEY);
            byte[] prv=(byte [])map.get(RSAUtils.PRIVATE_KEY);
            System.out.println(Base64.getEncoder().encodeToString(pub));
            System.out.println(Base64.getEncoder().encodeToString(prv));

            return "PublicKey:"+Base64.getEncoder().encodeToString(pub);

    }

    //多层级JSON
    @RequestMapping("multiLevelJson")
    @ResponseBody
    RetObject multiLevelJson(ModelMap model) {
        SysUser sysUser=new SysUser();
        sysUser.setEmail("123123123");

        return RetObject.genRetObject(SysCode.RET_Succ,"greate",sysUser);
    }

    //权限不足测试 ,未登录时会提示请先登录 /login，登录成功有会提示权限不足
    @RequestMapping("permissionDeny")
    @RequiresPermissions("sys:user:add")
    @ResponseBody
    RetObject permissionDeny(ModelMap model) {
        SysUser sysUser=new SysUser();
        sysUser.setEmail("123123123");

        return RetObject.genRetObject(SysCode.RET_Succ,"greate",sysUser);
    }

    @RequestMapping("mybatisInnerJoin")
    public void mybatisInnerJoin(BizWorker bizWorker){
        bizWorker.setEmail("123123");
        bizWorker.setRegionId(123L);
        bizWorker.getBizRegion().setId(456L);
        bizWorkerMapper.insertSelective(bizWorker);
    }

    @RequestMapping("getEntity")
    @ResponseBody
    public Object mybatisInnerJoin(String type){

        try {
            return Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
