package library;

import java.util.Scanner;

import library.config.HibernateConfiguration;
import library.dataaccess.BookDao;
import library.dataaccess.HibernateBookDao;
import library.dataaccess.JdbcBookDao;
import library.domain.Book;
import library.presentation.BookController;
import library.presentation.Controller;
import library.service.BookService;
import library.service.Service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class LibraryApplication {

	public static void main(String[] args) {

		BookDao bookDao;
		
		//bookDao = new JdbcBookDao();
		bookDao = new HibernateBookDao(HibernateConfiguration.getSessionFactory());
		Service bookService = new BookService(bookDao);
		Controller controller = new BookController(bookService);


		Scanner in = new Scanner(System.in);
		String command;
		boolean proceed = true;

		while (proceed) {

			controller.showMainMenu();
			command = in.nextLine();

			switch (command) {
			case "1":
				controller.register();
				break;

			case "2":
				controller.list();
				break;

			case "3":
				controller.update();
				break;

			case "4":
				controller.delete();
				break;

			case "exit":
				proceed = false;
				in.close();
				break;

			default:
				break;
			}
		}
		controller.close();
		System.out.println("Thanks for visiting.");
		HibernateConfiguration.closeSessionFactory();
	}
}
