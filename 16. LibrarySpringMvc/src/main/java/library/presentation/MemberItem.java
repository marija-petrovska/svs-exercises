package library.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.domain.Member;
import library.service.IService;

@Component
public class MemberItem extends ManuItemBasic {
	
	protected IService libraryService;

	@Autowired
	public MemberItem(IService libraryService) {
		this.libraryService = libraryService;
	}

	@Override
	public void showMainMenu() {
		System.out.println("Enter: ");
		System.out.println("1. Register Member");
		System.out.println("2. List registered Members ");
		System.out.println("3. Update Member ");
		System.out.println("4. Unregister Member ");
		System.out.println("5. 'back' for back to sections ");
	}
	@Override
	public void register() {
		System.out.println("Enter member: email and name");
		String email = in.nextLine();
		String name = in.nextLine();
		try {
			libraryService.registerMember(email, name);
			System.out.println("Successfully registered member");
		} catch (RuntimeException e) {
			System.out.println("Faliure registering member");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void list() {
		System.out.println("All registred members are:");
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
	
	@Override
	public void update() {
		System.out.println("Insert Member id, email, name");
		try {
			int id = Integer.parseInt(in.nextLine());
			String email = in.nextLine();
			String name = in.nextLine();
			libraryService.updateMember(id, email, name);
			System.out.println("Successfully updated magazine");
		} catch (RuntimeException e) {
			System.out.println("Failure updating magazine");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete() {
		System.out.println("Insert id of the member to unregister");
		try {
			int id = Integer.parseInt(in.nextLine());
			libraryService.unregisterMember(id);
			System.out.println("Successfully unregister member");
		} catch (RuntimeException e) {
			System.out.println("Failure unregistering member");
			System.out.println(e.getMessage());
		}

	}


}	
