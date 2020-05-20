package com.itmuch.cloud.annotation;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itmuch.cloud.utils.OpenUrlUtils;
@Aspect
@Component
public class AuthAop {
	private Logger logger=LoggerFactory.getLogger("aop");

	@Pointcut("execution(* com.itmuch.cloud.controller.*Controller.*(..))")   //两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void excudeService() {}
	
	 @Around("excudeService()")
	 public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		 
		 HttpServletRequest  request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
		 String requestURI = request.getRequestURI();
		 logger.info("requestURI:"+requestURI);
		 if(requestURI.contains("/user")) {
			 if(OpenUrlUtils.openUrl(requestURI)) {
				 logger.info("是开放路径");
			 }else {
				 logger.error("未登录");
				 //进行登录判断
				 throw new ApplicationContextException("请登录"); 
			 }
		 }
		 Object result = pjp.proceed();
		 return result ;
	 }


}
