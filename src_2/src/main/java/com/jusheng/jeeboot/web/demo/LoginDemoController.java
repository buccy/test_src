package com.jusheng.jeeboot.web.demo;

import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.system.AppConst;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.jusheng.jeeboot.utils.LogUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;


@Controller
@RequestMapping("/")
public class LoginDemoController {
    @RequestMapping("getPublicKey")
    @ResponseBody
    RetObject getPublicKey(HttpServletRequest request){
        byte[] rsaPublicKey=(byte[])request.getSession().getAttribute(AppConst.ENCRYPT_PUBLIC_KEY);
        RetObject retObject=null;
        if(rsaPublicKey==null){
           retObject=RetObject.genRetObject(SysCode.RET_Err_Biz,"can not get the rsa",null);
        }else{

            retObject=RetObject.genRetObject(SysCode.RET_Succ,"success", Base64.encode(rsaPublicKey));
        }
        return retObject;
    }

    /**
     * 请求登录页面
     * @param request
     * @return
     */
    @RequestMapping(value = "login",method= RequestMethod.GET)
    String login(HttpServletRequest request){
        System.out.println(request.getParameter("username"));
        Subject subject= SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            return "index";
        }else {
            return "login";
        }
    }

    /**
     * 尝试登陆
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = {"login",""},method= RequestMethod.POST)
    public String loginUser(String username, String password,String  vrifycode,ModelMap model, HttpSession session) {
        //校验-验证码是否正确
        String captchaId =(String) session.getAttribute("vrifyCode");
        if(!captchaId.equals(vrifycode)){
            model.addAttribute("info","错误的验证码");
            return "login";//返回登录页面
        }

        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            SysUser user=(SysUser) subject.getPrincipal();
            session.setAttribute("user", user);
            LogUtils.logger.error("login success");
            model.put("time", new Date());
            model.put("message", "Welcome to home page");
            return "index";
        } catch(Exception e) {
            return "login";//返回登录页面
        }
    }
    @RequestMapping("logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }
}
