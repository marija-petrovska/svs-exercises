package com.project.twitter.service;

import java.util.Comparator;

import com.project.twitter.domain.Tweet;

public class TweetSequenceComparator implements Comparator<Tweet> {

	@Override
	public int compare(Tweet t1, Tweet t2) {
		if (t1.getId() < t2.getId())
			return 1;
		else if (t1.getId() > t2.getId())
			return -1;
		else
			return 0;
		}
}