package library.service;

import java.util.List;

import library.domain.Book;

public interface Service {

	void registerBook(String isbn, String title);

	List<Book> getRegisteredBooks();

	void updateTitle(String title, Long id);

	void unregisterBook(Long id);

}
