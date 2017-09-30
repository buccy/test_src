package com.jusheng.jeeboot.system;

import org.springframework.stereotype.Component;

/*
    用于JSON的数据交互结果类
 */
@Component
public class RetObject {
    String retCode;//返回代码
    String retMsg;//返回消息
    Object data;//返回数据

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data=data;
    }

    public static RetObject genRetObject(String retCode, String retMsg, Object data){
        RetObject retObject=new RetObject();
        retObject.setRetCode(retCode);
        retObject.setRetMsg(retMsg);
        retObject.setData(data);
        return retObject;
    }

    /**
     * 生成，成功返回包
     * @param retMsg
     * @param data
     * @return
     */
    public static RetObject genSuccess(String retMsg, Object data){
        RetObject retObject=new RetObject();
        retObject.setRetCode(SysCode.RET_Succ);
        retObject.setRetMsg(retMsg);
        retObject.setData(data);
        return retObject;
    }

    /**
     * 生成业务错误返回包
     * @param retMsg
     * @param data
     * @return
     */
    public static RetObject genBizErr(String retMsg, Object data){
        RetObject retObject=new RetObject();
        retObject.setRetCode(SysCode.RET_Err_Biz);
        retObject.setRetMsg(retMsg);
        retObject.setData(data);
        return retObject;
    }

    /**
     * 生成系统错误返回包
     * @param retMsg
     * @param data
     * @return
     */
    public static RetObject genSysErr(String retMsg, Object data){
        RetObject retObject=new RetObject();
        retObject.setRetCode(SysCode.RET_Err_Sys);
        retObject.setRetMsg(retMsg);
        retObject.setData(data);
        return retObject;
    }
}
