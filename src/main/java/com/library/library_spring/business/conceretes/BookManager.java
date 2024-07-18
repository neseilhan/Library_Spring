package com.library.library_spring.business.conceretes;

import com.library.library_spring.business.abstracts.IBookService;
import com.library.library_spring.core.config.Msg;
import com.library.library_spring.core.exception.BookNotFoundException;
import com.library.library_spring.core.exception.NotFoundException;
import com.library.library_spring.dao.BookRepo;
import com.library.library_spring.dao.CategoryRepo;
import com.library.library_spring.entities.Book;
import com.library.library_spring.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements IBookService {
    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;


    public BookManager(BookRepo bookRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Book save(Book book) {
        Book savedBook = this.bookRepo.save(book);
        for (Category category : book.getCategoryList()) {
            category.getBookList().add(savedBook);
            categoryRepo.save(category);
        }
        return savedBook;
    }

    @Override
    public Book get(int id) {
        return this.bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        bookRepo.deleteById(id);
        return true;
    }
}
