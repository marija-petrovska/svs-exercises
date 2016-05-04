package com.project.twitter.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.twitter.domain.Tweet;
import com.project.twitter.service.Service;

@Controller
@RequestMapping("/tweets")
public class TweetWebController {

	@Autowired
	private Service tweetService;
	
	@ModelAttribute
	public Tweet tweet(){
		return new Tweet();
	}
	
	@ModelAttribute(value="tweets")
	public List<Tweet> tweets(){
		return tweetService.listMessages();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listMessages(){
		return "tweets";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerTweet(Tweet tweet) {
		tweetService.tweetMessage(tweet.getUsername(), tweet.getMessage());
		return "redirect:/tweets";
	}
	
	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public String unregisterBook(@RequestParam("id") Long id) {
		tweetService.deleteTweet(id);
		return "redirect:/tweets";
	}
	
}
