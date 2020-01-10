package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignService;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	 @Autowired
	 private   UserFeignService userFeignService;
	
	@GetMapping("/movie/{id}")
	@ResponseBody
	private User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://localhost:7910/find/"+id, User.class);
	}
	
	 /*
	    消费者的接口，去调用服务提供者
	    问题：只能使用@RequestMapping("/consumerHello/{name}")  @PathVariable("name")方法 不知道有没有其它方式代替？
	 */
	@RequestMapping("/consumerHello/{name}")
	public String index(@PathVariable("name") String name){
	    return userFeignService.sayHello(name);
	}
	//有问题的
	//@RequestMapping("/consumerHello2")
	//public String index2(@RequestParam("name") String name){
	//    return helloRemote.sayHello(name);
	//}
	@RequestMapping("/info")
	public String info(){
	    return " Hi,I am a consumer!";
	}

}
