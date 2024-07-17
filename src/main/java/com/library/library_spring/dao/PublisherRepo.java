package com.library.library_spring.dao;

import com.library.library_spring.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
