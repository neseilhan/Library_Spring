package com.library.library_spring.dao;

import com.library.library_spring.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
