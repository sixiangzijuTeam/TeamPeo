package com.itmuch.cloud.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {
	 /** 
	    * @方法描述: 注入ServerEndpointExporter，
	     *      * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
	    * @return: org.springframework.web.socket.server.standard.ServerEndpointExporter
	    * @Author: carry
	    */
	    @Bean
	    public ServerEndpointExporter serverEndpointExporter() {
	        return new ServerEndpointExporter();
	    }
}
