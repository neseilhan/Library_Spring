package com.library.library_spring.business.conceretes;

import com.library.library_spring.business.abstracts.IPublisherService;
import com.library.library_spring.dao.PublisherRepo;
import com.library.library_spring.entities.BookBorrowing;
import com.library.library_spring.entities.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PublisherManager implements IPublisherService {
    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return null;
    }

    @Override
    public Publisher get(int id) {
        return null;
    }

    @Override
    public Publisher update(Publisher publisher) {
        return null;
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
