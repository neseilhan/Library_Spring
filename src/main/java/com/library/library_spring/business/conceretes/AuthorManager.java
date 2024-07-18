package com.library.library_spring.business.conceretes;

import com.library.library_spring.business.abstracts.IAuthorService;
import com.library.library_spring.core.config.Msg;
import com.library.library_spring.core.exception.NotFoundException;
import com.library.library_spring.dao.AuthorRepo;
import com.library.library_spring.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorManager implements IAuthorService {
    private final AuthorRepo authorRepo;

    public AuthorManager(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public Author get(int id) {
        return this.authorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Author update(Author author) {
        this.get(author.getId());
        return this.authorRepo.save(author);
    }

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return authorRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        authorRepo.deleteById(id);
        return true;
    }
}
