package com.jusheng.jeeboot.system.exception;

import com.jusheng.jeeboot.system.RetObject;

import java.util.Map;

/**
 * Bean校验
 */
public class BeanValidException extends Exception {

    private Object data;
//    Map<String,String> validMsg
    public BeanValidException(String msg, Object validMsg){
        super(msg);
        this.data=validMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
