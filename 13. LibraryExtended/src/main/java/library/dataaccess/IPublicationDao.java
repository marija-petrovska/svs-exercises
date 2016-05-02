package library.dataaccess;

import java.util.List;

import library.domain.Book;
import library.domain.Magazine;
import library.domain.Publication;

public interface IPublicationDao {

	void saveBook(Book book);

	void saveMagazine(Magazine magazine);

	List<Book> getRegisteredBooks();

	List<Magazine> getRegisteredMagazines();
	
	void updateTitlePublication(Integer id, String title);

	void unregisterPublication(Integer id);
	
	List<Publication> listRegisteredPublications();

}