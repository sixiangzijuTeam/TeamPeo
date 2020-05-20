package com.itmuch.cloud.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_test_01")
public class Reciver  {
	
	@RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:" + hello);
    }

}
