package com.jusheng.jeeboot.utils;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	public static final String yyMMdd = "yy-MM-dd";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String DOUBLE = "^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$";
	public static final String INTEGER = "^-?(([1-9]\\d*$)|0)";
	public static final String EMAIL = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";

	/**
	 * 判断字符串是否为非空(包含null与"","    ")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmptyIgnoreBlank(String str) {
		if (str == null || "".equals(str) || "".equals(str.trim()))
			return false;
		return true;
	}

	/**
	 * 判断是否为浮点数或者整数
	 * 
	 * @param str
	 * @return true Or false
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字段是否为DOUBLE 符合返回ture
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isDouble(String str) {
		return Pattern.matches(DOUBLE, str);
	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		return Pattern.matches(INTEGER, str);
	}

	/**
	 * 判断是否为日期
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDataFormat(String str) {
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
		format.setLenient(false); 
		// SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		// 设置日期转化成功标识
		boolean dateflag = true;
		// 这里要捕获一下异常信息
		try {
			format.parse(str);
		} catch (Exception e) {
			dateflag = false;
		}
		return dateflag;
	}

	/**
	 * 验证Email
	 * 
	 * @param email
	 *            email地址，格式：zhangsan@zuidaima.com，zhangsan@xxx.com.cn，
	 *            xxx代表邮件服务商
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkEmail(String email) {
		return Pattern.matches(EMAIL, email);
	}

	/**
	 * 判断字段是否符合长度 超过长度{minleng}且 小于{maxleng}返回ture 其他返回false
	 * 
	 * @param str
	 * @param minleng
	 * @param maxleng
	 * @return boolean
	 */
	public static boolean isLengOut(String str, int minleng, int maxleng) {
		return str.trim().length() < maxleng && str.trim().length() > minleng;
	}

}
