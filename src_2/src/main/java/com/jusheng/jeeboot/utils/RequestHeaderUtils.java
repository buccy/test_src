package com.jusheng.jeeboot.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/9/20.
 */
public class RequestHeaderUtils {
    /**
     * 判断是否是  Ajax 请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
