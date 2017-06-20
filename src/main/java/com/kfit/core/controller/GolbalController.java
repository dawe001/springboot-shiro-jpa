package com.kfit.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GolbalController {

	@ExceptionHandler(value = Exception.class)
	public String defaultErrorHandler(HttpServletRequest request, Exception e, Map<String, Object> map) throws Exception {
		String exception = (String) request.getAttribute("shiroLoginFailure");
		String msg = "";
		System.out.println(exception);
		System.out.println(e.getMessage());
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				msg = " 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				msg = " 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				msg = "验证码错误";
			} else {
				msg = exception;
			}
		}
		map.put("msg", msg);
		return "/login";
	}
}
