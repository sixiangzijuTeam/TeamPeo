package com.itmuch.cloud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmuch.cloud.annotation.UserAnnotation;
import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRp;
	
	@ResponseBody
	@GetMapping("finduserbyid/{id}")
	@UserAnnotation(myvalue = "tian")
	public Optional<User> findUserById(@PathVariable Long id) {
		System.out.println("进入");
		 Optional<User> one = this.userRp.findById(id);
		return one;
	}
	
	@ResponseBody
	@GetMapping("/ceshi/{id}")
	@UserAnnotation(myvalue = "tians")
	public Optional<User> ceshi(@PathVariable Long id) {
		System.out.println("进入");
		 Optional<User> one = this.userRp.findById(id);
		return one;
	}
}
