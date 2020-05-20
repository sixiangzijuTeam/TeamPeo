package com.itmuch.cloud.controller;

import javax.servlet.http.HttpServletRequest;

public class Test {
	public static void main(String[] args) {
		for(;;) {
		 System.out.println( (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1))*5));
		 }
	}
	public String aa(HttpServletRequest request){
		if (request.getHeader("x-forwarded-for") == null) { 
			   return request.getRemoteAddr(); 
			  } 
			  return request.getHeader("x-forwarded-for"); 
	}
}
