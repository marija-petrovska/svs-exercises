package library;

import java.util.Scanner;

import library.presentation.Controller;
import library.presentation.LibraryController;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner,ApplicationContextAware {

	private ApplicationContext context;

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	
	@Override
	public void run(String... args) throws Exception {

		Controller controller = context.getBean(LibraryController.class);

		boolean proceed = true;

		Scanner in = new Scanner(System.in);

		while (proceed) {

			System.out.println("1. Book section ");
			System.out.println("2. Magazine section ");
			System.out.println("3. Member section ");
			System.out.println("4. Lending publication section ");
			System.out.println("5. 'exit' for logout ");

			String command = in.nextLine();

			switch (command) {
			case "1":
				controller.runItem1();
				break;
			case "2":
				controller.runItem2();
				break;
			case "3":
				controller.runItem3();
				break;
			case "4":
				controller.runItem4();
				break;
			case "exit":
				proceed = false;
				in.close();
				break;

			default:
				break;
			}
		}
		System.out.println("Thanks for visiting.");
	}
}
