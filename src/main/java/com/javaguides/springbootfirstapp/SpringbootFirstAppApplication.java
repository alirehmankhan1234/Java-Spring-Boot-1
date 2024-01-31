package com.javaguides.springbootfirstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class HelloWorld {

	private String message;

	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("Parameterized Constructor Invoked.");
	}

	public HelloWorld() {
		super();
		System.out.println("Default Constructor Invoked.");
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorld [Message=" + this.message + "]";
	}


}


@SpringBootApplication
public class SpringbootFirstAppApplication {

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld obj =(HelloWorld) context.getBean("helloWorldAnother");
		System.out.println(obj);
		SpringApplication.run(SpringbootFirstAppApplication.class, args);
	}

}
