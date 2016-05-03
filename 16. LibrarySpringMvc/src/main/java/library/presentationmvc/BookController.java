package library.presentationmvc;

import java.util.List;

import library.domain.Book;
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
@RequestMapping("/books")
public class BookController {

	@Autowired
	private IService libraryService;

	@ModelAttribute
	public Book book() {
		return new Book();
	}

	@ModelAttribute(value = "books")
	public List<Book> books() {
		return libraryService.getRegisteredBooks();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listBooks() {
		return "books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Integer id, Model model) {
		Book book = libraryService.findBook(id);
		model.addAttribute("book", book);
		return "books";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerOrUpdateBook(Book book) {
		if (book.getId() == 0) {
			libraryService.registerBook(book.getIsbn(), book.getTitle());
		} else {
			libraryService.updateBookRegistration(book);
		}
		return "redirect:/books";
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public String unregisterBook(@RequestParam("id") Integer id) {
		libraryService.unregisterBook(id);
		return "redirect:/books";
	}

}