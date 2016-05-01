package library.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.domain.Book;

public class JdbcBookDao implements BookDao {

	@Override
	public void registerBook(Book book) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("insert into book(isbn, title) values (?, ?)");
			statement.setString(1, book.getIsbn());
			statement.setString(2, book.getTitle());
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
	public List<Book> getRegisteredBooks() {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<Book> books = new ArrayList<Book>();

		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from book");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String isbn = resultSet.getString("isbn");
				String title = resultSet.getString("title");
				books.add(new Book(id, isbn, title));
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
		return books;
	}

	@Override
	public void updateTitle(String title, Long id) {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("update book set title=? where id=?");
			statement.setString(1, title);
			statement.setLong(2, id);
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
	public void unregisterBook(Long id) {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("delete from book where id = ?");
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
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "Password1");
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "hellosql");
		return connection;
	}
}
