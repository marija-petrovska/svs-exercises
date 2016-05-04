package com.project.twitter.dataaccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.twitter.domain.Tweet;

public class InMemoryTweetDao implements TweetDao {

	private static Long id = 0L;
	private static Map<Long, Tweet> tweetMap = new HashMap<Long, Tweet>();

	@Override
	public void saveTweet(Tweet tweet) {

		id++;
		tweet.setId(id);
		tweetMap.put(id, tweet);
	}

	@Override
	public List<Tweet> listTweets() {

		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		for (Map.Entry<Long, Tweet> entry : tweetMap.entrySet()) {
			tweets.add(entry.getValue());
		}
		return tweets;
	}

	@Override
	public void deleteTweet(Long id) {
		if (tweetMap.get(id) == null) {
			throw new RuntimeException("no such tweet");
		}
		tweetMap.remove(id);
	}
}
