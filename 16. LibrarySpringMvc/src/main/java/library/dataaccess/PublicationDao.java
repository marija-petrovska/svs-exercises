package library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import library.domain.Book;
import library.domain.Magazine;
import library.domain.Publication;
import library.exceptions.NoSuchEntryException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicationDao implements IPublicationDao {

	SessionFactory sessionFactory;

	@Autowired
	public PublicationDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void saveMagazine(Magazine magazine) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(magazine);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Book> getRegisteredBooks() {
		List<Book> books = new ArrayList<Book>();
		Session session = sessionFactory.openSession();
		Criteria crit;
		try {
			crit = session.createCriteria(Book.class);
			books = crit.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return books;
	}

	@Override
	public List<Magazine> getRegisteredMagazines() {
		List<Magazine> magazines = new ArrayList<Magazine>();
		Session session = sessionFactory.openSession();
		Criteria crit;
		try {
			crit = session.createCriteria(Magazine.class);
			magazines = crit.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return magazines;
	}
	
	@Override
	public void updateTitlePublication(Integer id, String title) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Publication publication = (Publication) session.get(Publication.class, id);
			publication.setTitle(title);
			session.save(publication);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void unregisterPublication(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Publication publication = (Publication) session.get(Publication.class, id);
			if (publication == null) {
				throw new NoSuchEntryException("publication");
			}
			Query query = session.createQuery("delete from Publication where id=:id");
			query.setLong("id", id);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Publication> listRegisteredPublications() {

		Session session = sessionFactory.openSession();
		List<Publication> publications = new ArrayList<Publication>();
		Criteria crit;
		try {
			crit = session.createCriteria(Publication.class);
			publications = crit.list();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return publications;
	}
	
	//for Mvc
	//update isbn too
	@Override
	public void updateBookRegistration(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book bookNew = (Book) session.get(Book.class, book.getId());
			bookNew.setTitle(book.getTitle());
			bookNew.setIsbn(book.getIsbn());
			session.save(bookNew);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}
	//update issn too
	@Override
	public void updateMagazineRegistration(Magazine magazine) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Magazine magazineNew = (Magazine) session.get(Magazine.class, magazine.getId());
			magazineNew.setTitle(magazine.getTitle());
			magazineNew.setIssn(magazine.getIssn());
			session.save(magazineNew);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	
	@Override
	public Book findBook(Integer id) {
		Session session = sessionFactory.openSession();
		Book book;
		try {
			book = (Book) session.get(Book.class, id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return book;
	}

	@Override
	public Magazine findMagazine(Integer id) {
		Session session = sessionFactory.openSession();
		Magazine magazine;
		try {
			magazine = (Magazine) session.get(Magazine.class, id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return magazine;
	}
}
