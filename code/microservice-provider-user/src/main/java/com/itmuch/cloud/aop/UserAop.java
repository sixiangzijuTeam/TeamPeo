package com.itmuch.cloud.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.itmuch.cloud.annotation.UserAnnotation;

@Aspect
@Component
public class UserAop {
	
	 	@Pointcut(value = "@annotation(com.itmuch.cloud.annotation.UserAnnotation)")
	    public void pointCut() {
	    }
	 	
	 	@Before("pointCut()")
	 	public void before(JoinPoint j) throws Throwable{
	 		UserAnnotation annotation = ((MethodSignature)j.getSignature()).getMethod().getAnnotation(UserAnnotation.class);
	 		String myvalue = annotation.myvalue();
	 		System.out.println(myvalue);
//	 		if(myvalue.equalsIgnoreCase("tian")) {
//	 			return proceed=null;
//	 		}else {
//	 			proceed = j.proceed();
//	 		}
	 	}
	 	
//	 	@Around("pointCut()")
//	 	public Object around(ProceedingJoinPoint j) throws Throwable{
////	 		Object[] args = j.getArgs();
////	 		System.out.println("args:"+Arrays.asList(args).toString());
////	 		String kind = j.getKind();
////	 		System.out.println("kind:"+kind);
////	 		
////	 		Signature signature = j.getSignature();
////	 		System.out.println("signature:"+signature.toString());
////	 		System.out.println("signature:"+signature.getModifiers());
////	 		System.out.println("signature:"+signature.getName());
////	 		System.out.println("signature:"+signature.getDeclaringTypeName());
////	 		
////	 		StaticPart staticPart = j.getStaticPart();
////	 		System.out.println("staticPart:"+staticPart.toString());
////	 		System.out.println("staticPart:"+staticPart.getId());
////	 		
////	 		Object target = j.getTarget();
////	 		System.out.println("target:"+target.toString());
////	 		
////	 		Object this1 = j.getThis();
////	 		System.out.println("this1:"+this1);
//	 		
//	 		MethodSignature ss = (MethodSignature)j.getSignature();
//	 		
////	 		String[] parameterNames = ss.getParameterNames();
////	 		for (String string : parameterNames) {
////	 			System.out.println("parameterNames:"+string);
////			}
////	 		
////	 		Class[] parameterTypes = ss.getParameterTypes();
////	 		for (Class string : parameterTypes) {
////	 			System.out.println("parameterTypes:"+string);
////			}
//	 		
//	 		UserAnnotation m = ss.getMethod().getAnnotation(UserAnnotation.class);
//	 		String myvalue = m.myvalue();
////	 		System.out.println("myvalue:"+myvalue);
////	 		Parameter[] parameters = ss.getMethod().getParameters();
////	 		for (Parameter string : parameters) {
////	 			System.out.println("parameters:"+string.getName());
////			}
////	 		
////	 		Annotation[] annotations = ss.getMethod().getAnnotations();
////	 		for (Annotation string : annotations) {
////	 			System.out.println("annotations:"+string.toString());
////			}
//	 		Object proceed;
//	 		System.out.println("qian");
//	 		if(myvalue.equalsIgnoreCase("tian")) {
//	 			return proceed=null;
//	 		}else {
//	 			proceed = j.proceed();
//	 		}
//	 		System.out.println("hout");
//	 		return proceed;
//	 	}
}
