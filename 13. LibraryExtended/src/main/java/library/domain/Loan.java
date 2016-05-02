package library.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Member member;

	@ManyToOne
	private Publication publication;

	private Date startDate;

	private Date endDate;

	public Loan() {
	}

	public Loan(int id) {
		this.id = id;
	}

	public Loan(Member member, Publication publication) {
		this.member = member;
		this.publication = publication;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Loan [id=" + id + ", member=" + member + ", publication="
				+ publication + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
