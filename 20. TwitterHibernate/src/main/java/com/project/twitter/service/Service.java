package com.project.twitter.service;

import java.util.List;

import com.project.twitter.domain.Tweet;

public interface Service {

	void tweetMessage(String username, String message);

	List<Tweet> listMessages();

	void deleteTweet(Long id);

}