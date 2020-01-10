package com.itmuch.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* 描述：调用用户服务
* @author chuan
* @since 1.0
* @date 2020年1月10日
*/
@Service
@FeignClient(name= "user-client")
public interface UserFeignService {
	 //需要匹配服务提供者接口名称
    @RequestMapping(value = "/producerHello")
    public String sayHello(@RequestParam(value="name") String name);
}
