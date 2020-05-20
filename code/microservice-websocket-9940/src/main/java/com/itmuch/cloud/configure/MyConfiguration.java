package com.itmuch.cloud.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyConfiguration  extends WebMvcConfigurationSupport{
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);//是否发送cookie
    }
	
//	@Bean
//	 public WebMvcConfigurer corsConfigurer() {
//
//	     return new WebMvcConfigurerAdapter() {
//
//	         @Override
//
//	          public void addCorsMappings(CorsRegistry registry) {
//
//	              registry.addMapping("/**")
//
//	              .allowCredentials(true)
//
//	              .allowedMethods("GET");
//
//	           }
//
//	       };
//
//	     }
}
