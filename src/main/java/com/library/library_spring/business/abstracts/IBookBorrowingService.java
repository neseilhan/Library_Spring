package com.library.library_spring.business.abstracts;
import com.library.library_spring.entities.Author;
import com.library.library_spring.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);

    BookBorrowing get(int id);

    BookBorrowing update(BookBorrowing bookBorrowing);

    Page<BookBorrowing> cursor(int page, int pageSize);

    boolean delete(int id);


}
