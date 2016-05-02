package library.presentation;

import java.util.Scanner;

public abstract class ManuItemBasic {
	
	protected Scanner in = new Scanner(System.in);
	
	protected abstract void showMainMenu();
	
	protected abstract void register();

	protected abstract void list();
	
	protected abstract void update();

	protected abstract void delete();
	
	public void run() {

		boolean proceed = true;
		while (proceed) {

			showMainMenu();
			String command = in.nextLine();

			switch (command) {
			case "1":
				register();
				break;

			case "2":
				list();
				break;

			case "3":
				update();
				break;

			case "4":
				delete();
				break;

			case "back":
				proceed = false;
				break;

			default:
				break;
			}
		}
	}
}
