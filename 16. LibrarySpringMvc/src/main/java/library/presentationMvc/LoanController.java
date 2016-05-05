package library.presentationMvc;

import java.util.List;

import library.domain.Member;
import library.domain.Publication;
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
@RequestMapping("/loans")
public class LoanController {

	@Autowired
	private IService libraryService;

	@ModelAttribute(value = "members")
	public List<Member> members() {
		return libraryService.getRegisteredMembers();
	}

	@ModelAttribute(value = "publications")
	public List<Publication> publications() {
		return libraryService.getRegisteredPublications();
	}

	@ModelAttribute(value = "member")
	public Member member() {
		return new Member();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listLoans() {
		return "loans";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String makeLoan(@PathVariable("id") Integer id, Model model) {
		Member member = new Member();
		member = libraryService.findMember(id);
		model.addAttribute("member", member);
		return "loans";
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public String unregisterLoan(@RequestParam("mid") Integer mid, @RequestParam("pid") Integer pid) {
		libraryService.returnLoan(mid, pid);
		return "redirect:/loans";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerLoan(Member member,@RequestParam("publication") Integer pid) {
		libraryService.loanPublication(member.getId(), pid);
		return "redirect:/loans";
	}

}