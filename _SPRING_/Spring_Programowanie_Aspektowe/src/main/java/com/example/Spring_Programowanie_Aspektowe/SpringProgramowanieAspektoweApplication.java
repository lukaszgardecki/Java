package com.example.Spring_Programowanie_Aspektowe;

import com.example.Spring_Programowanie_Aspektowe.api.IKucharz;
import com.example.Spring_Programowanie_Aspektowe.api.InterfejsZapiekanka;
import com.example.Spring_Programowanie_Aspektowe.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringProgramowanieAspektoweApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringProgramowanieAspektoweApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IKucharz k = (IKucharz) context.getBean("kucharz");

		((InterfejsZapiekanka)k).przygotujZapiekanke();
	}

}
