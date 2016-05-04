package com.project.twitter.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.twitter.domain.Tweet;

@Component
public class HibernateTweetDao implements TweetDao {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateTweetDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveTweet(Tweet tweet) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(tweet);
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

	public List<Tweet> listTweets() {
		Session session = sessionFactory.openSession();
		List<Tweet> tweets = new ArrayList<Tweet>();
		try {
			String hql = "FROM Tweet";
			Query query = session.createQuery(hql);
			tweets = query.list();
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return tweets;
	}

	public void deleteTweet(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Tweet tweet = (Tweet) session.get(Tweet.class, id);
			if (tweet == null) {
				throw new RuntimeException("No such tweet");
			}
			Query query = session.createQuery("delete from Tweet where id=:id");
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
