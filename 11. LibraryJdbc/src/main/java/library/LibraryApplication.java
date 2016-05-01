package library;

import java.util.Scanner;

import library.dataaccess.BookDao;
import library.dataaccess.JdbcBookDao;
import library.presentation.BookController;
import library.presentation.Controller;
import library.service.BookService;
import library.service.Service;

public class LibraryApplication {

	public static void main(String[] args) {

		BookDao bookDao = new JdbcBookDao();
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
	}
}
