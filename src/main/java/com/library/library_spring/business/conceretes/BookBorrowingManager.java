package com.library.library_spring.business.conceretes;

import com.library.library_spring.business.abstracts.IBookBorrowingService;
import com.library.library_spring.core.config.Msg;
import com.library.library_spring.core.exception.InsufficientStockException;
import com.library.library_spring.core.exception.NotFoundException;
import com.library.library_spring.dao.BookBorrowingRepo;
import com.library.library_spring.dao.BookRepo;
import com.library.library_spring.dao.CategoryRepo;
import com.library.library_spring.entities.Book;
import com.library.library_spring.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowingManager implements IBookBorrowingService {
    private final CategoryRepo categoryRepo;
    private final BookBorrowingRepo bookBorrowingRepo;
    private final BookRepo bookRepo;

    public BookBorrowingManager(CategoryRepo categoryRepo, BookBorrowingRepo bookBorrowingRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookBorrowingRepo = bookBorrowingRepo;
        this.bookRepo = bookRepo;
    }


    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        Book book = bookBorrowing.getBook();
        if (book.getStock() <= 0) {
            throw new InsufficientStockException(Msg.INSUFFICIENT_STOCK);
        }
        book.setStock(book.getStock() - 1);
        bookRepo.save(book);
        return bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(int id) {
        return bookBorrowingRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
//        BookBorrowing existingBookBorrowing = get(bookBorrowing.getId());
//        existingBookBorrowing.setBook(bookBorrowing.getBook());
//        existingBookBorrowing.setName(bookBorrowing.getName());
//        existingBookBorrowing.setBorrowingDate(bookBorrowing.getBorrowingDate());
//        existingBookBorrowing.setReturn_date(bookBorrowing.getReturn_date());
//        return bookBorrowingRepo.save(existingBookBorrowing);

        this.get(bookBorrowing.getId());
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return bookBorrowingRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        BookBorrowing bookBorrowing = get(id);
        Book book = bookBorrowing.getBook();
        book.setStock(book.getStock() + 1);
        bookRepo.save(book);
        bookBorrowingRepo.deleteById(id);
        return true;
    }
}
