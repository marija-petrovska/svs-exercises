package com.project.twitter;

import com.project.twitter.dataaccess.InMemoryTweetDao;
import com.project.twitter.dataaccess.TweetDao;
import com.project.twitter.presentation.Controller;
import com.project.twitter.presentation.TweetController;
import com.project.twitter.service.Service;
import com.project.twitter.service.TweetService;

public class TwitterApplication {
	public static void main(String[] args) {

		TweetDao tweetDao = new InMemoryTweetDao();
		Service tweetService = new TweetService(tweetDao);
		Controller controller = new TweetController(tweetService);

		controller.run();

		System.out.println("Thank you for visiting.");
	}
}
