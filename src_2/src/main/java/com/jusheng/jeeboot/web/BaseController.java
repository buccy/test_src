package com.jusheng.jeeboot.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;

import com.jusheng.jeeboot.entity.BaseEntity;
import com.jusheng.jeeboot.entity.SysRole;
import com.jusheng.jeeboot.service.BaseService;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.jusheng.jeeboot.system.config.validator.BeanValidators;
import com.jusheng.jeeboot.system.exception.BeanValidException;
import com.jusheng.jeeboot.system.exception.BizErrorException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import static com.jusheng.jeeboot.system.SysCode.RET_Err_Biz_Valid;

@ControllerAdvice
public abstract class BaseController{

	/** 验证Bean实例对象*/
	@Autowired
	protected Validator validator;

	@Autowired
	protected MessageSource messageSource;

	protected Locale locale;

	//在controller所有方法加载前初始化这个local
	@ModelAttribute
	private void Init(Locale locale){
		this.locale=locale;
	}

	protected void beanValidator(BindingResult bindingResult) throws BeanValidException {
		List<ObjectError> objectErrorList=bindingResult.getAllErrors();

		if (objectErrorList.size()<=0){
			return;
		}

		Map<String,String> map=new HashMap<String,String>();
		bindingResult.getAllErrors().forEach(item->{
			map.put(((FieldError) item).getField(), item.getDefaultMessage());
		});

		System.out.println(objectErrorList);
		throw new BeanValidException("校验失败",map);
	}

	/**
	 * 全局异常捕捉处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler({Exception.class})
	public RetObject errorHandler(Exception ex, Locale locale) {
		ex.printStackTrace();
		return RetObject.genRetObject(SysCode.RET_Err_Sys,"系统异常",null);
	}

	/**
	 * 业务异常捕捉处理
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ExceptionHandler({BizErrorException.class})
	public RetObject bizErrorHandler(Exception ex, Locale locale) {
		ex.printStackTrace();
		return RetObject.genBizErr(ex.getMessage(),null);
	}

	/**
	 * 数据校验不符合
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ExceptionHandler({BeanValidException.class})
	public RetObject beanValidHandler(BeanValidException ex, Locale locale) {
		return RetObject.genRetObject(SysCode.RET_Err_Biz_Valid,ex.getMessage(),ex.getData());
	}

	/**
	 * 登录认证异常
	 */
	@ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
	@ResponseBody
	public RetObject authenticationException(HttpServletRequest request, HttpServletResponse response,Locale locale) {
		return RetObject.genRetObject(SysCode.RET_Err_Biz,
				messageSource.getMessage("sys.authen.fail",null,locale),
				null);
	}

	/**
	 * 权限异常
	 */
	@ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
	@ResponseBody
	public RetObject authorizationException(HttpServletRequest request, HttpServletResponse response,Locale locale,UnauthorizedException e) {
		return RetObject.genRetObject(SysCode.RET_Err_Biz,
				messageSource.getMessage("sys.author.fail",null,locale)+e.getMessage(),
				null);
	}

}
