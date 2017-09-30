package com.jusheng.jeeboot.system.security;

import com.jusheng.jeeboot.system.AppConst;
import com.jusheng.jeeboot.utils.LogUtils;
import com.jusheng.jeeboot.utils.RSAUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;


public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Value("${jeeboot.useRSAEncrypt}")
    private Boolean useRSAEncrypt=false;

    /**
     * 密码校验
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取当前请求变量
        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  ra.getRequest();
        byte[] privateKey=(byte [])request.getSession().getAttribute(AppConst.ENCRYPT_PRIVATE_KEY);


        UsernamePasswordToken utoken=(UsernamePasswordToken) token;

        //用私钥解密
        String decryptToken=null;
        if(useRSAEncrypt) {
            try {
                PrivateKey rsaPrivateKey = RSAUtils.restorePrivateKey(privateKey);
                decryptToken = RSAUtils.RSADecode(rsaPrivateKey, Base64.decode(String.valueOf(utoken.getPassword()).getBytes()));
            } catch (Exception e) {
                LogUtils.logger.error("decrypt password error");
                return false;
            }
        }else{
            decryptToken=String.valueOf(utoken.getPassword());
        }

        //将用户名和密码作MD5hash
        decryptToken=utoken.getUsername()+decryptToken;
        String MD5Hash=DigestUtils.md5DigestAsHex(decryptToken.getBytes());

        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword =DigestUtils.md5DigestAsHex(decryptToken.getBytes());
        //获得数据库中的密码
        String dbPassword=(String) info.getCredentials();
        //进行密码的比对
        return this.equals(inPassword, dbPassword);
    }

}