package library.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String name;

	@OneToMany(mappedBy = "member", fetch=FetchType.EAGER)
	private Set<Loan> loans;

	public Member(int id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public Member(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public Member() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	public void setLoan(Loan loan) {
		this.loans.add(loan);
	}

	public void deleteLoan(Loan loan) {
		this.loans.remove(loan);
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", name=" + name + "]";
	}

}
