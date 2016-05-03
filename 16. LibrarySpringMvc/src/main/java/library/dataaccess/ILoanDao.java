package library.dataaccess;

import java.util.List;

import library.domain.Loan;

public interface ILoanDao {

	void loanPublication(Integer memId, Integer pubId);

	List listLoanedPublications(Integer memId);

	void returnLoan(Integer memId, Integer pubId);

	List<Loan> getLoans();

}