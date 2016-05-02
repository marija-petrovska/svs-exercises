package library;
import java.util.Scanner;

import library.config.HibernateConfiguration;
import library.dataaccess.ILoanDao;
import library.dataaccess.IMemberDao;
import library.dataaccess.IPublicationDao;
import library.dataaccess.LoanDao;
import library.dataaccess.MemberDao;
import library.dataaccess.PublicationDao;
import library.presentation.BookItem;
import library.presentation.Controller;
import library.presentation.LibraryController;
import library.presentation.LoanItem;
import library.presentation.MagazineItem;
import library.presentation.MemberItem;
import library.service.IService;
import library.service.LibraryService;

import org.hibernate.SessionFactory;

public class LibraryApplication {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

		IPublicationDao publicationDao = new PublicationDao(sessionFactory);
		IMemberDao memberDao = new MemberDao(sessionFactory);
		ILoanDao loanDao = new LoanDao(sessionFactory);		
		IService libraryService = new LibraryService(publicationDao, memberDao, loanDao);
		
		BookItem book = new BookItem(libraryService);
		MagazineItem magazine = new MagazineItem(libraryService);
		MemberItem member = new MemberItem(libraryService);
		LoanItem loan = new LoanItem(libraryService);
		
		Controller libraryController = new LibraryController(book, magazine, member, loan);
		
		boolean proceed = true;

		Scanner in = new Scanner(System.in);
		
		while(proceed){
			
			System.out.println("1. Book section ");
			System.out.println("2. Magazine section ");
			System.out.println("3. Member section ");
			System.out.println("4. Lending publication section ");
			System.out.println("5. 'exit' for logout ");

			String command=in.nextLine();
			
			switch (command) {
			case "1":
				libraryController.runItem1();
				break;
			case "2":
				libraryController.runItem2();
				break;
			case "3":
				libraryController.runItem3();;
				break;
			case "4":
				libraryController.runItem4();
				break;
			case "exit":
				proceed=false;
				in.close();
				break;
				
			default:
				break;
			}
		}
		System.out.println("Thanks for visiting.");
		sessionFactory.close();
	}
}
