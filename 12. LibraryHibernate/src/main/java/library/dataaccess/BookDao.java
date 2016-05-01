package library.dataaccess;

import java.util.List;

import library.domain.Book;

public interface BookDao {

	void registerBook(Book book);

	List<Book> getRegisteredBooks();

	void updateTitle(String title, Long id);

	void unregisterBook(Long id);
}
