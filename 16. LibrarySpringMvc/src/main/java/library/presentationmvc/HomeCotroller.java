package library.presentationMvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCotroller {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

}
