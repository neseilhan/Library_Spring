package com.library.library_spring.business.abstracts;

import com.library.library_spring.entities.Book;
import com.library.library_spring.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save(Book book);

    Book get(int id);

    Book update(Book book);

    Page<Book> cursor(int page, int pageSize);

    boolean delete(int id);
}
