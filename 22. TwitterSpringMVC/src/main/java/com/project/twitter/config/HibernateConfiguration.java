package com.project.twitter.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.twitter.domain.Tweet;

@Configuration
public class HibernateConfiguration {

	@Bean
	public SessionFactory sessionFactory() {
		
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Tweet.class).buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}
	
	public void closeSessionFactory(){
		sessionFactory().close();
	}
}
