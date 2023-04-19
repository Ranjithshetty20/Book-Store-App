package com.BookstoreApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookstoreApp.entity.MybookList;

public interface MyBookRepositry extends JpaRepository<MybookList, Integer> {

}
