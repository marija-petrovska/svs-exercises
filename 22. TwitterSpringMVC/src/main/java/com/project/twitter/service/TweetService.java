package com.project.twitter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.twitter.dataaccess.TweetDao;
import com.project.twitter.domain.Tweet;

@Component
public class TweetService implements Service{

	private TweetDao tweetDao;

	@Autowired
	public TweetService(TweetDao twitterDao) {
		this.tweetDao = twitterDao;
	}

	public void tweetMessage(String username, String message) {
		Tweet tweet = new Tweet(username, message);
		tweetDao.saveTweet(tweet);
	}

	public List<Tweet> listMessages() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets = tweetDao.listTweets();
		Collections.sort(tweets, new TweetSequenceComparator());
		return tweets;
	}

	public void deleteTweet(Long id) {
		tweetDao.deleteTweet(id);
	}
}
