package library.service;

import java.util.List;

import library.domain.Book;
import library.domain.Magazine;
import library.domain.Member;
import library.domain.Publication;

public interface IService {

	void registerBook(String isbn, String title);

	List<Book> getRegisteredBooks();
	
	void updateTitleBook(Integer id, String title);

	void unregisterBook(Integer id);
	
	void registerMagazine(String issn, String title);

	List<Magazine> getRegisteredMagazine();
	
	void updateTitleMagazine(Integer id, String title);
	
	void unregisterMagazine(Integer id);
	
	List<Publication> getRegisteredPublications();
	
	void registerMember(String email, String name);

	List<Member> getRegisteredMembers();

	void updateMember(Integer id, String email, String name);

	void unregisterMember(Integer id);

	void loanPublication(Integer memId, Integer pubId);

	List<Publication> getLoanedPublications(Integer memId);

	void returnLoan(Integer memId, Integer pubId);

}
