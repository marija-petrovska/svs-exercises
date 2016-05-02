package library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import library.domain.Member;
import library.exceptions.NoSuchEntryException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MemberDao implements IMemberDao {

	SessionFactory sessionFactory;

	public MemberDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveMember(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(member);
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
	public List<Member> getRegisteredMembers() {
		Session session = sessionFactory.openSession();
		List<Member> members = new ArrayList<Member>();
		try {
			String hql = "FROM Member";
			Query query = session.createQuery(hql);
			members = query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return members;
	}

	@Override
	public void updateMember(Integer id, String email, String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Member member = (Member) session.get(Member.class, id);
			member.setEmail(email);
			member.setName(name);
			session.save(member);
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
	public void unregisterMember(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Member member = (Member) session.get(Member.class, id);
			if (member == null) {
				throw new NoSuchEntryException("member");
			}
			Query query = session.createQuery("delete from Member where id=:id");
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
}
