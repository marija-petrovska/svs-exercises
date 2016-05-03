package library.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Publication {

	@Column(unique = true)
	private String isbn;

	public Book() {
	}

	public Book(int id) {
		this.id = id;
	}

	public Book(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public Book(int id, String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + "]";
	}

}
