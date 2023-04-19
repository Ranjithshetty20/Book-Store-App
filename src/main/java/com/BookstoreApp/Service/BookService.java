package com.BookstoreApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookstoreApp.entity.Book;
import com.BookstoreApp.repository.BookRepositry;

@Service
public class BookService {
	@Autowired
	private BookRepositry  bookRepositry;
	
	public void save(Book book)
	{
		bookRepositry.save(book);
	}
	public List<Book> getAllBooks()
	{
		return bookRepositry.findAll();
	}
	
	public Book getMyBooksById(int id)
	{
		Book book=bookRepositry.findById(id).get();
		return book;
	}
	public void deleteBook(int id)
	{
		bookRepositry.deleteById(id);
	}
   

}
