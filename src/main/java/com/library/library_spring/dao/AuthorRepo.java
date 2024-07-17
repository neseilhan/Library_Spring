package com.library.library_spring.dao;

import com.library.library_spring.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
