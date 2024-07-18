package com.library.library_spring.business.conceretes;


import com.library.library_spring.business.abstracts.ICategoryService;
import com.library.library_spring.core.config.Msg;
import com.library.library_spring.core.exception.CategoryNotFoundException;
import com.library.library_spring.core.exception.NotFoundException;
import com.library.library_spring.dao.BookRepo;
import com.library.library_spring.dao.CategoryRepo;
import com.library.library_spring.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;
    private final BookRepo bookRepo;

    public CategoryManager(CategoryRepo categoryRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public String delete(int id) {
        Category category = get(id);
        if (bookRepo.existsByCategoryId(id)) {
            return Msg.CATEGORY_DELETE_ERROR;
        }
        categoryRepo.deleteById(id);
        return Msg.OK;
    }

}
