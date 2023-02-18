package net.emmecilab.rabbitmq.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import net.emmecilab.rabbitmq.demo.order.OrderMessage;

@Service
public class Publisher {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	CommandLineRunner sender() {
		
		return args -> {
			
			/*String message = "New order...";
			System.out.println(message);*/

			OrderMessage order = new OrderMessage();

			order.setCustomerName("Nome del mio customer");
			order.setCustomerAddress("Indirizzo del mio customer");
			order.setNotes("Note");

			List<Integer> productsId = new ArrayList<Integer>();
			productsId.add(10);
			productsId.add(23);
			productsId.add(32);
			productsId.add(67);
			
			order.setProductsIds(productsId);
		
			rabbitTemplate.convertAndSend("incoming-orders", order);
			
			System.out.println("Message sent");
		};
	}
}
