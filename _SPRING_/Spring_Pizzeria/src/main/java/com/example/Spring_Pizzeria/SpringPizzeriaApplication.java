package com.example.Spring_Pizzeria;

import com.example.Spring_Pizzeria.api.IOrder;
import com.example.Spring_Pizzeria.config.AutoConfig;
import com.example.Spring_Pizzeria.config.Config;
import com.example.Spring_Pizzeria.implementation.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringPizzeriaApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);

		IOrder order = context.getBean(IOrder.class);
		order.printOrder();

		IOrder order2 = context.getBean(Order.class);
		order2.printOrder();

	}

}
