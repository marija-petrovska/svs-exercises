package library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import library.domain.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateBookDao implements BookDao {

	SessionFactory sessionFactory;

	public HibernateBookDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void registerBook(Book book) {
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
	public List<Book> getRegisteredBooks() {

		Session session = sessionFactory.openSession();
		List<Book> books = new ArrayList<Book>();
		try {
			String hql = "FROM Book";
			Query query = session.createQuery(hql);
			books = query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return books;
	}

	@Override
	public void updateTitle(String title, Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = (Book) session.get(Book.class, id);
			book.setTitle(title);
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
	public void unregisterBook(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = (Book) session.get(Book.class, id);
			if (book == null) {	throw new RuntimeException("No such book");	}
			Query query = session.createQuery("delete from Book where id=:id");
			query.setLong("id", id);
			query.executeUpdate();
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
}
