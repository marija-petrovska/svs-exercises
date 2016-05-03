package library.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.domain.Magazine;
import library.service.IService;

@Component
public class MagazineItem extends ManuItemBasic {

	protected IService libraryService;

	@Autowired
	public MagazineItem(IService libraryService) {
		this.libraryService = libraryService;
	}

	@Override
	public void showMainMenu() {
		System.out.println("Enter: ");
		System.out.println("1. Register Magazine");
		System.out.println("2. List registered Magazines ");
		System.out.println("3. Update Magazine title ");
		System.out.println("4. Unregister Magazine ");
		System.out.println("5. 'back' for back to sections ");
	}

	@Override
	public void register() {
		System.out.println("Enter magazine issn and title");
		String issn = in.nextLine();
		String title = in.nextLine();
		try {
			libraryService.registerMagazine(issn, title);
			System.out.println("Successfully registered magazine");
		} catch (RuntimeException e) {
			System.out.println("Faliure registering magazine");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void list() {
		System.out.println("All registred magazines are:");
		try {
			List<Magazine> magazines = libraryService.getRegisteredMagazine();
			for (Magazine magazine : magazines) {
				System.out.println(magazine);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing magazines");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update() {
		System.out.println("Insert Magazine title and id");
		String title = in.nextLine();
		try {
			int id = Integer.parseInt(in.nextLine());
			libraryService.updateTitleMagazine(id, title);
			System.out.println("Successfully updated magazine");
		} catch (RuntimeException e) {
			System.out.println("Failure updating magazine");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete() {
		System.out.println("Insert id of the magazine to unregister");
		try {
			int id = Integer.parseInt(in.nextLine());
			libraryService.unregisterMagazine(id);
			System.out.println("Successfully unregister magazine");
		} catch (RuntimeException e) {
			System.out.println("Failure unregistering magazine");
			System.out.println(e.getMessage());
		}

	}
}
