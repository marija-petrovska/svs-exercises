package library.presentation;

public class LibraryController implements Controller {

	private BookItem book;
	private MagazineItem magazine;
	private MemberItem member;
	private LoanItem loan;

	public LibraryController(BookItem book, MagazineItem magazine,
			MemberItem member, LoanItem loan) {
		this.book = book;
		this.magazine = magazine;
		this.member = member;
		this.loan = loan;
	}

	@Override
	public void runItem1() {
		book.run();
	}

	@Override
	public void runItem2() {
		magazine.run();
	}

	@Override
	public void runItem3() {
		member.run();
	}

	@Override
	public void runItem4() {
		loan.run();
	}
}
