package com.jusheng.jeeboot.system.filter;

import com.jusheng.jeeboot.system.AppConst;
import com.jusheng.jeeboot.utils.LogUtils;
import com.jusheng.jeeboot.utils.RSAUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.logging.log4j.util.LoaderUtil;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 在shiro认证之前做的事情
 */
public class SysFilter extends AdviceFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        HttpSession session = httpRequest.getSession();

        //添加跨域允许
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        //为每个用户生成一个公私密钥
        if(session.getAttribute(AppConst.ENCRYPT_PUBLIC_KEY)==null) {
            Map<String,byte[]> map= RSAUtils.generateKeyBytes();
            byte[] publicKey=(byte [])map.get(RSAUtils.PUBLIC_KEY);
            byte[] privateKey=(byte [])map.get(RSAUtils.PRIVATE_KEY);
            session.setAttribute(AppConst.ENCRYPT_PUBLIC_KEY, publicKey);
            session.setAttribute(AppConst.ENCRYPT_PRIVATE_KEY, privateKey);

            LogUtils.logger.debug("privateKey:"+ Base64.encode(privateKey));
            LogUtils.logger.debug("publicKy:"+ Base64.encode(publicKey));
            //初始化登录错误次数为0
            session.setAttribute(AppConst.LOGIN_ERROR_COUNT,0);
        }

        return true;
    }
}