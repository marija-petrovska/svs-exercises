package com.project.twitter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.project.twitter.dataaccess.TweetDao;
import com.project.twitter.domain.Tweet;

public class TweetService implements Service {

	private TweetDao tweetDao;

	public TweetService(TweetDao twitterDao) {
		this.tweetDao = twitterDao;
	}

	@Override
	public void tweetMessage(String username, String message) {
		Tweet tweet = new Tweet(username, message);
		tweetDao.saveTweet(tweet);
	}

	@Override
	public List<Tweet> listMessages() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets = tweetDao.listTweets();
		Collections.sort(tweets, new TweetSequenceComparator());
		return tweets;
	}
	
	@Override
	public void deleteTweet(Long id){
		tweetDao.deleteTweet(id);
	}

}
