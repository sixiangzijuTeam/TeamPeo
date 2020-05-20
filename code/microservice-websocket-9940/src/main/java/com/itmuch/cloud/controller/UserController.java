package com.itmuch.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmuch.cloud.utils.AjaxResult;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@ResponseBody
	@RequestMapping("/find")
	public AjaxResult findTest() {
		return success();
	}
	
	@RequestMapping("/find1")
	public String findTest1() {
		return "成功";
	}
}
