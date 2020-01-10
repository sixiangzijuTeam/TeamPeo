package com.itmuch.cloud.controller;

import java.util.Optional;

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
    public String Hello(){
        return "hello xxx，this is demo-client1 messge";
    }
	 
	 @RequestMapping("/producerHello")
    public String Hello(@RequestParam("name") String name){
        return "hello " + name + "，this is demo-client1 messge";
    }
}
