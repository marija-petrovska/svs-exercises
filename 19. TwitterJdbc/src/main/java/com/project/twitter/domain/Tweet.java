package com.project.twitter.domain;

public class Tweet {

	private Long id;
	private String message;
	private String username;

	public Tweet(String username, String message) {
		this.username = username;
		this.message = message;
	}

	public Tweet(Long id, String username, String message) {
		this.id = id;
		this.username = username;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tweet [id = " + id + ", message = " + message + ", username = "
				+ username + "]";
	}

}
