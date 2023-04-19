package com.BookstoreApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BookstoreApp.Service.BookService;
import com.BookstoreApp.Service.MyBooksService;
import com.BookstoreApp.entity.Book;
import com.BookstoreApp.entity.MybookList;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBooksService booksService1;
	
    @GetMapping("/")
	public String home()
	{
		return "home.html";
	}
    @GetMapping("/book_register")
    public String bookregister() {
    	
    	return "bookRegister.html";
    }
    @GetMapping("/available_books")
    public ModelAndView getallbook()
    {
    	List<Book> list=bookService.getAllBooks();
    	ModelAndView m=new ModelAndView();
    	m.setViewName("availableBook");
    	m.addObject("book",list);
    	//or
//    	return new ModelAndView("booklist","book",list);
    	return m;
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book)
    {
    	bookService.save(book);
    	return "redirect:/available_books";
    }
    
    @GetMapping("/my_Books")
    public ModelAndView getMyBooks()
    {
    	List<MybookList> list =booksService1.getAllMyBooks();
    	ModelAndView  m=new ModelAndView();
    	m.setViewName("myBooks");
    	m.addObject("mybooks",list);
    	return m;
    }
//    @GetMapping("/my_Books")
//    public String getMyBooks(Model model)
//    {
//    	List<MybookList> list =booksService1.getAllMyBooks();
//    	model.addAttribute("mybook",list);
//    	return "myBooks";
//    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@ModelAttribute @PathVariable("id") int id)
    {
    	Book book=bookService.getMyBooksById(id);
    	MybookList list=new MybookList(book.getId(),book.getAuthore(),book.getNamee(),book.getPrice());
    	booksService1.saveMyBooks(list);
    	
    	return "redirect:/my_Books"; 
    }
    @RequestMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") int id)
    {
    	bookService.deleteBook(id);
    	return "redirect:/available_books";
    }
    @RequestMapping("/edite/{id}")
    public String editeBooks(@PathVariable("id") int id,Model model)
    {
      Book b=bookService.getMyBooksById(id);
    	model.addAttribute("book",b);
    	return "updatehtml.html";
    	
    }
    
    
}

