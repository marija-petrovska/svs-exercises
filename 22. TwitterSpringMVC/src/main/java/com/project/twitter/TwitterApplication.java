package com.project.twitter;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.project.twitter.presentation.Controller;
import com.project.twitter.presentation.TweetController;

@SpringBootApplication
public class TwitterApplication implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.context = applicationContext;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Controller controller = context.getBean(TweetController.class);
		controller.run();
		System.out.println("Thank you for visiting.");
		System.exit(0);
	}
}
