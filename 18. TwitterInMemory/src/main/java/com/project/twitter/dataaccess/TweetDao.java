package com.project.twitter.dataaccess;

import java.util.List;

import com.project.twitter.domain.Tweet;

public interface TweetDao {

	void saveTweet(Tweet tweet);

	List<Tweet> listTweets();

	void deleteTweet(Long id);

}