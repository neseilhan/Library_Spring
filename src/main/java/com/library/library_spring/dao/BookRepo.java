package com.library.library_spring.dao;

import com.library.library_spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
