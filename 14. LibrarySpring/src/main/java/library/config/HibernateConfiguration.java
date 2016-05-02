package library.config;

import javax.annotation.PreDestroy;

import library.domain.Book;
import library.domain.Loan;
import library.domain.Magazine;
import library.domain.Member;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfiguration {

	@Bean
	public SessionFactory sessionFactory() {

		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Loan.class).addAnnotatedClass(Member.class)
				.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}

	@PreDestroy
	public void closeSessionFactory() {
		sessionFactory().close();
	}
}