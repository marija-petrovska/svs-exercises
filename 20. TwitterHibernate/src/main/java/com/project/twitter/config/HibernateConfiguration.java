package com.project.twitter.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.project.twitter.domain.Tweet;

public class HibernateConfiguration {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Tweet.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	public static void closeSessionFactory(){
		sessionFactory.close();
	}
}
