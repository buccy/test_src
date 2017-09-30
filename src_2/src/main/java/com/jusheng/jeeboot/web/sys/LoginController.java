package com.jusheng.jeeboot.web.sys;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.system.AppConst;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.jusheng.jeeboot.utils.LogUtils;
import com.jusheng.jeeboot.web.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sys")
public class LoginController extends BaseController{

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     *
     * @api {getPublicKey} /api/sys/getPublicKey
     * @apiDescription 获取公钥
     * @apiGroup Login
     * @apiName getPublicKey
     * @apiVersion 1.0.0
     *
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/sys/getPublicKey
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回数据
     * @apiSuccessExample {json} Success-Response:
     *  {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {
    publicKey:XXXXXXXXXXXXX434
    }
    ]
    }
     *
     */
    @RequestMapping("getPublicKey")
    public RetObject getPublicKey(HttpServletRequest request){
        Map<String,Object> retMap=new HashMap<>();

        RSAPublicKey rsaPublicKey=(RSAPublicKey)request.getSession().getAttribute(AppConst.ENCRYPT_PUBLIC_KEY);
        RetObject retObject=null;
        if(rsaPublicKey==null){
            retObject=RetObject.genSysErr("can not get the rsa",null);
        }else{
            retMap.put("publicKey",Base64.getEncoder().encode(rsaPublicKey.getEncoded()));
            retObject=RetObject.genSuccess("can not get the rsa", retMap);
        }
        return retObject;
    }

    /**
     *
     * @return
     */

    /**
     *
     * @api {login} /api/sys/login
     * @apiDescription  请求登录
     * @apiGroup Login
     * @apiName list
     * @apiVersion 1.0.0
     * @apiParam {String} username  用户名
     * @apiParam {String} password 密码
     * @apiParam {String} captcha 验证码(登陆错误次数X>=3 传入)
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/sys/login
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回SysLog的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {
    NeedCheckCaptcha：false
    }
    ]
    }
     *
     */
    @RequestMapping(value="login",method = RequestMethod.POST)
    public RetObject login(String username, String password, String captcha, HttpSession session){
        Map<String,Object> retMap=new HashMap<>();

        //告诉前端是否需要显示验证码
        retMap.put("NeedCheckCaptcha",false);

        //如果验证密码错误次数超过3次，才会启动验证码错误校验
        Integer loginErrCount=(Integer)session.getAttribute(AppConst.LOGIN_ERROR_COUNT);
        if(loginErrCount>=AppConst.LOGIN_ERROR_MAX_COUNT){
            if(session.getAttribute(AppConst.LOGIN_CAPTCHA)==null){
                return RetObject.genBizErr("captcha doesn't exist",null);
            }
            if (captcha.equals(session.getAttribute(AppConst.LOGIN_CAPTCHA))){
                return RetObject.genBizErr("captcha identify error",null);
            }
            retMap.put("NeedCheckCaptcha",true);
        }


        //校验密码，并返回结果
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
        } catch(AuthenticationException|UnauthorizedException e) {
            session.setAttribute(AppConst.LOGIN_ERROR_COUNT,++loginErrCount);
            return RetObject.genBizErr("login fail",null);
        }

        SysUser user=(SysUser) subject.getPrincipal();
        session.setAttribute("user", user);
        LogUtils.logger.info("login success:"+user.getLoginName());
        return RetObject.genSuccess("login success",null);
    }


    /**
     *
     * @api {logout} /api/sys/logout
     * @apiDescription 注销登出
     * @apiGroup Login
     * @apiName logout
     * @apiVersion 1.0.0
     *
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/sys/logout
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回数据
     * @apiSuccessExample {json} Success-Response:
     *  {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping("logout")
    public RetObject logout(){
        //用户未登录
        //用户注销
        return RetObject.genSuccess("logout success",null);
    }




    /**
     *
     * @api {getCaptcha} /api/sys/getCaptcha
     * @apiDescription 获取验证码图片生成链接
     * @apiGroup Login
     * @apiName getCaptcha
     * @apiVersion 1.0.0
     *
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/sys/getCaptcha
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回数据
     * @apiSuccessExample {json} Success-Response:
     *  {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {
    LOGIN_CAPTCHA:6g46
    }
    ]
    }
     *
     */
    @RequestMapping("/getCaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute(AppConst.LOGIN_CAPTCHA, createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


}
