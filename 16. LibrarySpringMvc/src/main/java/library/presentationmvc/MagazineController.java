package library.presentationMvc;

import java.util.List;

import library.domain.Magazine;
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
@RequestMapping("/magazines")
public class MagazineController {

	@Autowired
	private IService libraryService;

	@ModelAttribute
	public Magazine magazine() {
		return new Magazine();
	}

	@ModelAttribute(value = "magazines")
	public List<Magazine> magazines() {
		return libraryService.getRegisteredMagazine();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listMagazines() {
		return "magazines";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editMagazine(@PathVariable("id") Integer id, Model model) {
		Magazine magazine = libraryService.findMagazine(id);
		model.addAttribute("magazine", magazine);
		return "magazines";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerOrUpdateMagazine(Magazine magazine) {
		if (magazine.getId() == 0) {
			libraryService.registerMagazine(magazine.getIssn(), magazine.getTitle());
		} else {
			libraryService.updateMagazineRegistration(magazine);
		}
		return "redirect:/magazines";
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public String unregisterMagazine(@RequestParam("id") Integer id) {
		libraryService.unregisterMagazine(id);
		return "redirect:/magazines";
	}

}