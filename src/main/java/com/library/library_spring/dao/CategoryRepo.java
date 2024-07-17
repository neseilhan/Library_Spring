package com.library.library_spring.dao;

import com.library.library_spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
