package library.config;

import library.domain.Book;
import library.domain.Loan;
import library.domain.Magazine;
import library.domain.Member;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Magazine.class).addAnnotatedClass(Loan.class)
				.addAnnotatedClass(Member.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

}
