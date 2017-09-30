package com.jusheng.jeeboot.system;

/**
 * Created by Administrator on 2017/9/14.
 */
public class AppConst {
    /**
     * 登录前分配的公私钥，用于登录时的加密，私钥用于解密
     */
    public final static String ENCRYPT_PUBLIC_KEY="ENCRYPT_PUBLIC_KEY";
    public final static String ENCRYPT_PRIVATE_KEY="ENCRYPT_PRIVATE_KEY";

    //登录成功之后返回的token串
    public final static String LOGIN_TOKEN="LOGIN_TOKEN";

    //登录验证码
    public final static String LOGIN_CAPTCHA="LOGIN_CAPTCHA";
    //登录错误次数
    public final static String LOGIN_ERROR_COUNT="LOGIN_ERROR_COUNT";
    //登录最大错误次数，超过该次数则需要校验验证码
    public final static Integer LOGIN_ERROR_MAX_COUNT=3;
}
