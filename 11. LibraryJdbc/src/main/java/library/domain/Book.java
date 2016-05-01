package library.domain;

public class Book {

	// autoincrement in DB
	private Long id;
	private String isbn;
	private String title;

	public Book(Long id, String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
		this.id = id;
	}

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
