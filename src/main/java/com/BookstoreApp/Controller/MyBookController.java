package com.BookstoreApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookstoreApp.Service.MyBooksService;

@Controller
public class MyBookController {
	
	@Autowired
	private MyBooksService booksService;
	
	@RequestMapping("/myBooklist/{id}")
	public String deleteMyList(@PathVariable("id") int id)
	{
		booksService.deleteBooksById(id);
		return "redirect:/my_Books";
	}

}
