package com.itmuch.cloud.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;

@RestController
public class TestController {
	
	@Autowired
	private UserRepository userRp;
	
	@ResponseBody
	@GetMapping("/find/{id}")
	public Optional<User> findTest(@PathVariable Long id){
		Optional<User> findById = this.userRp.findById(id);
		return findById;
	}
	
	 @RequestMapping("/info")
    public String Hello(HttpServletRequest request){
		 String str="";
		 if (request.getHeader("x-forwarded-for") == null) { 
			 str= request.getRemoteAddr() +1; 
		  } else {
			  str=request.getHeader("x-forwarded-for")+2; 
		  }
		
        return "hello xxx，this is demo-client1 messge:"+str;
    }
	 
	 @RequestMapping("/producerHello")
    public String Hello(@RequestParam("name") String name){
        return "hello " + name + "，this is demo-client1 messge";
    }
}
