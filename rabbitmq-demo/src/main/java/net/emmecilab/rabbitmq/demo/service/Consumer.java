package net.emmecilab.rabbitmq.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import net.emmecilab.rabbitmq.demo.order.OrderMessage;

@Service
public class Consumer {

	@RabbitListener(queues = "incoming-orders")
 public void receiver(OrderMessage message){
	System.out.println("Received : "  + message);
}
}

