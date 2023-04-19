package com.BookstoreApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookstoreApp.entity.Book;
@Repository
public interface BookRepositry extends JpaRepository<Book, Integer> {
	
	

}
