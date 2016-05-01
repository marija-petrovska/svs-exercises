package library.presentation;

import java.util.List;
import java.util.Scanner;
import library.domain.Book;
import library.service.Service;

public class BookController implements Controller {

	private Service bookService;
	private Scanner in = new Scanner(System.in);

	public BookController(Service bookService) {
		this.bookService = bookService;
	}

	@Override
	public void showMainMenu() {
		System.out.println("Enter: ");
		System.out.println("1 for Registering a Book ");
		System.out.println("2 for listing Registered Books ");
		System.out.println("3 for update Registration ");
		System.out.println("4 for unregister Book ");
		System.out.println("5 Enter 'exit' for logout ");
	}

	@Override
	public void register() {

		System.out.println("Enter isbn and title");

		String isbn = in.nextLine();
		String title = in.nextLine();

		try {
			bookService.registerBook(isbn, title);
			System.out.println("Successfully registered book");
		} catch (RuntimeException e) {
			System.out.println("Faliure registering book");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void list() {

		System.out.println("All registred books are: ");

		try {
			List<Book> books = bookService.getRegisteredBooks();
			for (Book book : books){
				System.out.println(book);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing books");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update() {

		System.out.println("Insert update details, title and id: ");

		String title = in.nextLine();

		try {
			Long id = (Long.parseLong(in.nextLine()));			
			bookService.updateTitle(title, id);			
			System.out.println("Successfully updated book");
		}catch(NumberFormatException e){
			System.out.println("Incorrect input format");
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Failure updating book");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete() {

		System.out.println("Insert id of the book to unregister");
		
		try {
			Long id = (Long.parseLong(in.nextLine()));
			bookService.unregisterBook(id);
			System.out.println("Successfully unregistered book");
		}catch(NumberFormatException e){
			System.out.println("Incorrect input format");
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Failure unregistering book");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void close() {
		in.close();
	}
}
