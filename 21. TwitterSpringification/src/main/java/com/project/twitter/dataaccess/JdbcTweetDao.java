package com.project.twitter.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.twitter.domain.Tweet;

public class JdbcTweetDao implements TweetDao {

	@Override
	public void saveTweet(Tweet tweet) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("insert into tweet(username, message) values (?, ?)");
			statement.setString(1, tweet.getUsername());
			statement.setString(2, tweet.getMessage());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public List<Tweet> listTweets() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();

		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from tweet");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String message = resultSet.getString("message");
				String username = resultSet.getString("userName");
				tweets.add(new Tweet(id, username, message));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return tweets;
	}
	
	@Override
	public void deleteTweet(Long id) {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("delete from tweet where id = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/twitter", "postgres", "Password1");
		return connection;
	}
}
