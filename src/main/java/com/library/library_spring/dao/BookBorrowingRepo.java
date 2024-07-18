package com.library.library_spring.dao;

import com.library.library_spring.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingRepo extends JpaRepository<BookBorrowing, Integer> {
}
