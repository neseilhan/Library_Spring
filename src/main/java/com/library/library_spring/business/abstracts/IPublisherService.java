package com.library.library_spring.business.abstracts;

import com.library.library_spring.entities.BookBorrowing;
import com.library.library_spring.entities.Publisher;
import org.springframework.data.domain.Page;

public interface IPublisherService {
    Publisher save(Publisher publisher);

    Publisher get(int id);

    Publisher update(Publisher publisher);

    Page<BookBorrowing> cursor(int page, int pageSize);

    boolean delete(int id);
}
