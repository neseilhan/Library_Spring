package com.library.library_spring.dao;

import com.library.library_spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    boolean existsByCategoryId(int categoryId);

    List<Book> findByCategoryId(int categoryId);
}
