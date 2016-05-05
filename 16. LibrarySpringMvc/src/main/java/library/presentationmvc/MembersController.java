package library.presentationMvc;

import java.util.List;

import library.domain.Member;
import library.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MembersController {

	@Autowired
	private IService libraryService;

	@ModelAttribute
	public Member member() {
		return new Member();
	}

	@ModelAttribute(value = "members")
	public List<Member> members() {
		return libraryService.getRegisteredMembers();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listMembers() {
		return "members";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editMember(@PathVariable("id") Integer id, Model model) {
		Member member = libraryService.findMember(id);
		model.addAttribute("member", member);
		return "members";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerOrUpdateMember(Member member) {
		if (member.getId() == 0) {
			libraryService.registerMember(member.getEmail(), member.getName());
		} else {
			libraryService.updateMember(member.getId(), member.getEmail(),	member.getName());
		}
		return "redirect:/members";
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public String unregisterMember(@RequestParam("id") Integer id) {
		libraryService.unregisterMember(id);
		return "redirect:/members";
	}

}