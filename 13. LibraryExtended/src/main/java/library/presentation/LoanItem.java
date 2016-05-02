package library.presentation;

import java.util.List;
import java.util.Scanner;

import library.domain.Member;
import library.domain.Publication;
import library.service.IService;

public class LoanItem {

	private Scanner in = new Scanner(System.in);

	private IService libraryService;

	public LoanItem(IService libraryService) {
		this.libraryService = libraryService;
	}

	public void run() {

		boolean proceed = true;
		while (proceed) {

			showMainMenuLibrary();
			String command = in.nextLine();

			switch (command) {
			case "1":
				listAllPublications();
				break;

			case "2":
				listAllMembers();
				break;

			case "3":
				listMemberLoans();
				break;

			case "4":
				loan();
				break;

			case "5":
				returnloan();
				break;

			case "back":
				proceed = false;
				break;

			default:
				break;
			}
		}
	}

	private void showMainMenuLibrary() {
		System.out.println("Enter: ");
		System.out.println("1. List registered publications ");
		System.out.println("2. List regesitered members ");
		System.out.println("3. List Member's loaned publications ");
		System.out.println("4. Member to loan Publication ");
		System.out.println("5. Member to return loan");
		System.out.println("6. 'back' for back to sections ");
	}

	private void listAllPublications() {
		System.out.println("All registered publications are :");
		try {
			List<Publication> publications = libraryService.getRegisteredPublications();
			for (Publication publication : publications) {
				System.out.println(publication);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing publications");
			System.out.println(e.getMessage());
		}
	}

	private void listAllMembers() {
		System.out.println("All registered members are:");
		try {
			List<Member> members = libraryService.getRegisteredMembers();
			for (Member member : members) {
				System.out.println(member);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing members");
			System.out.println(e.getMessage());
		}
	}

	private void listMemberLoans() {

		System.out.println("Insert memberId to list his loans ");
		try {
			int memId = Integer.parseInt(in.nextLine());
			System.out.println("All loaned publications for member " + memId + " :");
			List<Publication> publications = libraryService.getLoanedPublications(memId);
			for (Publication publication : publications) {
				System.out.println(publication);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing publications");
			System.out.println(e.getMessage());
		}
	}

	private void loan() {
		System.out.println("Insert memberId and publicationId to loan");
		try {
			int memId = Integer.parseInt(in.nextLine());
			int pubId = Integer.parseInt(in.nextLine());
			libraryService.loanPublication(memId, pubId);
			System.out.println("Successfully loaned pulblication");
		} catch (RuntimeException e) {
			System.out.println("Failure loaning pulblication");
			System.out.println(e.getMessage());
		}
	}

	private void returnloan() {
		System.out.println("Insert memberId and publicationId to return");
		try {
			int memId = Integer.parseInt(in.nextLine());
			int pubId = Integer.parseInt(in.nextLine());
			libraryService.returnLoan(memId, pubId);
			System.out.println("Successfully returned loan");
		} catch (RuntimeException e) {
			System.out.println("Failure returning loan");
			System.out.println(e.getMessage());
		}
	}
}
