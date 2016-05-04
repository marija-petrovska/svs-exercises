package com.project.twitter.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.twitter.domain.Tweet;
import com.project.twitter.service.Service;

@RestController()
@RequestMapping("/api/tweets")
public class TweetRestController {

	@Autowired
	private Service tweetService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> listTweets() {
		return tweetService.listMessages();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Tweet registerBook(@RequestBody Tweet tweet) {
		tweetService.tweetMessage(tweet.getUsername(), tweet.getMessage());
		return tweet;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String unregisterBook(@PathVariable("id") Long id) {
		tweetService.deleteTweet(id);
	return "Success";
	}
}
