package library.service;

import java.util.List;

import library.dataaccess.BookDao;
import library.domain.Book;

public class BookService implements Service{
	
	private BookDao bookDao;

	public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public void registerBook(String isbn, String title){
		Book book = new Book(isbn, title);
		bookDao.registerBook(book);
	}
	
	@Override
	public List<Book> getRegisteredBooks(){
		List<Book>books = bookDao.getRegisteredBooks();
		return books;
	}
	
	@Override
	public void updateTitle(String title, Long id){
		bookDao.updateTitle(title, id);
	}
	
	@Override
	public void unregisterBook(Long id){
		bookDao.unregisterBook(id);
	}
}
