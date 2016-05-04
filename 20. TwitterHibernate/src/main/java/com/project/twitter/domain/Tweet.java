package com.project.twitter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tweet {

	@Id
	@GeneratedValue
	private Long id;
	private String message;

	@Column(unique = true)
	private String username;

	public Tweet() {

	}

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
