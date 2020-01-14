package com.itmuch.cloud.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UserUtils {
		
	public final static String USER_SESSION_INFO="USER_SESSION_INFO";
	
	public final static String CURRENT_USER="CURRENT_USER";
	
	public  static ServletRequestAttributes servletRequestAttributes=null;
	
	private String getUsernameSession() {
		servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String name = (String) request.getAttribute(UserUtils.CURRENT_USER);
		return  name;
		
		//网上获取对话的方法
//		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//	      Object attribute = request.getAttribute(UserUtils.CURRENT_USER);
	}
	
}
