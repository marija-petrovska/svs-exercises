package library.service;

import java.util.List;

import library.dataaccess.ILoanDao;
import library.dataaccess.IMemberDao;
import library.dataaccess.IPublicationDao;
import library.domain.Book;
import library.domain.Magazine;
import library.domain.Member;

public class LibraryService implements IService {

	private IPublicationDao publicationDao;

	private IMemberDao memberDao;

	private ILoanDao loanDao;

	public LibraryService(IPublicationDao publicationDao, IMemberDao memberDao,
			ILoanDao loanDao) {
		this.publicationDao = publicationDao;
		this.memberDao = memberDao;
		this.loanDao = loanDao;
	}
	
	//publication

	public void registerBook(String isbn, String title) {
		Book book = new Book(isbn, title);
		publicationDao.saveBook(book);
	}

	public List<Book> getRegisteredBooks() {
		List<Book> books = publicationDao.getRegisteredBooks();
		return books;
	}

	public void updateTitleBook(Integer id, String title) {
		publicationDao.updateTitlePublication(id, title);
	}

	public void unregisterBook(Integer id) {
		publicationDao.unregisterPublication(id);
	}

	public void registerMagazine(String issn, String title) {
		Magazine magazine = new Magazine(issn, title);
		publicationDao.saveMagazine(magazine);
	}

	public List<Magazine> getRegisteredMagazine() {
		List<Magazine> magazines = publicationDao.getRegisteredMagazines();
		return magazines;
	}

	public void updateTitleMagazine(Integer id, String title) {
		publicationDao.updateTitlePublication(id, title);
	}

	public void unregisterMagazine(Integer id) {
		publicationDao.unregisterPublication(id);
	}
	
	public List getRegisteredPublications() {
		return publicationDao.listRegisteredPublications();
	}


	// member

	public void registerMember(String email, String name) {
		Member member = new Member(email, name);
		memberDao.saveMember(member);
	}

	public List<Member> getRegisteredMembers() {
		List<Member> members = memberDao.getRegisteredMembers();
		return members;
	}

	public void updateMember(Integer id, String email, String name) {
		memberDao.updateMember(id, email, name);
	}

	public void unregisterMember(Integer id) {
		memberDao.unregisterMember(id);
	}

	// loan

	public List getLoanedPublications(Integer memId) {
		return loanDao.listLoanedPublications(memId);
	}

	public void loanPublication(Integer memId, Integer pubId) {
		loanDao.loanPublication(memId, pubId);
	}

	public void returnLoan(Integer memId, Integer pubId) {
		loanDao.returnLoan(memId, pubId);
	}

}
