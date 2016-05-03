package library.presentationmvc;

import java.util.List;

import library.domain.Book;
import library.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/books")
public class BookRestController{
	
	@Autowired
	private IService libraryService;
		
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> listBooks() {
		return libraryService.getRegisteredBooks();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Book registerBook(@RequestBody Book book) {
		libraryService.registerBook(book.getIsbn(), book.getTitle());
		return book;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Book updateBookRegistration(@RequestBody Book book,@PathVariable("id") int id) {
		book.setId(id);
		libraryService.updateBookRegistration(book);
	return book;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String unregisterBook(@PathVariable("id") int id) {
		libraryService.unregisterBook(id);
	return "Success";
	}
}
