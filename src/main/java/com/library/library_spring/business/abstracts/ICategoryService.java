package com.library.library_spring.business.abstracts;

import com.library.library_spring.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save(Category category);

    Category get(int id);

    Category update(Category category);

    Page<Category> cursor(int page, int pageSize);

    boolean delete(int id);
}
