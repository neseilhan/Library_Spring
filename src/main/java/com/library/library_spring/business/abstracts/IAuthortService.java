package com.library.library_spring.business.abstracts;

import com.library.library_spring.entities.Author;
import org.springframework.data.domain.Page;

public interface IAuthortService {
    Author save(Author author);

    Author get(int id);

    Author update(Author author);

    Page<Author> cursor(int page, int pageSize);

    boolean delete(int id);


}
