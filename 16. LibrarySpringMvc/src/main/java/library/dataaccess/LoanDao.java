package library.dataaccess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import library.domain.Loan;
import library.domain.Member;
import library.domain.Publication;
import library.exceptions.NoSuchEntryException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanDao implements ILoanDao {

	SessionFactory sessionFactory;

	@Autowired
	public LoanDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void loanPublication(Integer memId, Integer pubId) {
		Session session = sessionFactory.openSession();
		Set<Loan> loans = new HashSet<Loan>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Member member = (Member) session.get(Member.class, memId);
			Publication publication = (Publication) session.get(Publication.class, pubId);
			if (member == null || publication == null) {
				throw new NoSuchEntryException("member or publication");
			}
			loans = member.getLoans();
			for (Loan loan : loans) {
				if (loan.getPublication() == publication) {
					throw new RuntimeException("Already loaned publication");
				}
			}
			Loan loan = new Loan();
			loan.setPublication(publication);
			loan.setMember(member);
			session.save(loan);
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
	public List listLoanedPublications(Integer memId) {
		Session session = sessionFactory.openSession();
		List<Publication> publications = new ArrayList<Publication>();
		Set<Loan> loans = new HashSet<Loan>();
		try {
			Member member = (Member) session.get(Member.class, memId);
			if (member == null) {
				throw new NoSuchEntryException("member");
			}
			loans = member.getLoans();
			for (Loan loan : loans) {
				// condition if working with dates...
				if (loan.getEndDate() == null)
					publications.add(loan.getPublication());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return publications;
	}

	@Override
	public void returnLoan(Integer memId, Integer pubId) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(Loan.class);
			crit.createAlias("member", "m");
			crit.add(Restrictions.eq("m.id", memId));
			crit.createAlias("publication", "p");
			crit.add(Restrictions.eq("p.id", pubId));

			Loan loan = (Loan) crit.uniqueResult();
			if (loan == null) {
				throw new NoSuchEntryException("loan");
			}
			Query query = session.createQuery("delete from Loan where publication_id=:pid and member_id=:mid");
			query.setLong("pid", pubId);
			query.setLong("mid", memId);
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
	public List<Loan> getLoans() {
		List<Loan> loans = new ArrayList<Loan>();
		Session session = sessionFactory.openSession();
		Criteria crit;
		try {
			crit = session.createCriteria(Loan.class);
			loans = crit.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return loans;
	}
}
