package library.presentation;

import java.util.List;

import library.domain.Book;
import library.service.IService;

public class BookItem extends ManuItemBasic {

	protected IService libraryService;

	public BookItem(IService libraryService) {
		this.libraryService = libraryService;
	}

	@Override
	public void showMainMenu() {
		System.out.println("Enter: ");
		System.out.println("1. Register Book");
		System.out.println("2. List registered Books ");
		System.out.println("3. Update Book title ");
		System.out.println("4. Unregister Book ");
		System.out.println("5. 'back' for back to sections ");
	}

	@Override
	public void register() {
		System.out.println("Enter Book isbn and title");
		String isbn = in.nextLine();
		String title = in.nextLine();
		try {
			libraryService.registerBook(isbn, title);
			System.out.println("Successfully registered book");
		} catch (RuntimeException e) {
			System.out.println("Faliure registering book");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void list() {
		System.out.println("All registered books are: ");
		try {
			List<Book> books = libraryService.getRegisteredBooks();
			for (Book book : books) {
				System.out.println(book);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing books");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update() {
		System.out.println("Insert Book title and id");
		String title = in.nextLine();
		try {
			int id = Integer.parseInt(in.nextLine());
			libraryService.updateTitleBook(id, title);
			System.out.println("Successfully updated book");
		} catch (RuntimeException e) {
			System.out.println("Failure updating book");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete() {
		System.out.println("Insert id of the book to unregister");
		try {
			int id = Integer.parseInt(in.nextLine());
			libraryService.unregisterBook(id);
			System.out.println("Successfully unregister book");
		} catch (RuntimeException e) {
			System.out.println("Failure unregistering book");
			System.out.println(e.getMessage());
		}
	}

}
