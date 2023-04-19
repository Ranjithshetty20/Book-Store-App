package com.BookstoreApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookstoreApp.entity.Book;
import com.BookstoreApp.entity.MybookList;
import com.BookstoreApp.repository.MyBookRepositry;

@Service
public class MyBooksService {

	@Autowired
	private MyBookRepositry bookRepositry;
	
	public void saveMyBooks(MybookList list)
	{
		bookRepositry.save(list);
	}
	
	public List<MybookList> getAllMyBooks()
	{
		List<MybookList> list =bookRepositry.findAll();
		return list;
	}
	public void deleteBooksById(int id)
	{
		bookRepositry.deleteById(id);
	}
	
	
}
