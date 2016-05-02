package library.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Publication {

	@Column(unique = true)
	private String issn;

	public Magazine(int id, String issn, String title) {
		this.issn = issn;
		this.title = title;
		this.id = id;
	}

	public Magazine(String issn, String title) {
		this.issn = issn;
		this.title = title;
	}

	public Magazine(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public Magazine(int id) {
		this.id = id;
	}

	public Magazine() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", issn=" + issn + ", title=" + title
				+ "]";
	}

}
