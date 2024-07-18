package com.library.library_spring.dao;

import com.library.library_spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

//    boolean existsByCategoryId(int categoryId);
//    List<Book> findByCategoryId(int categoryId);

    @Query("SELECT b FROM Book b JOIN b.categoryList c WHERE c.id = :categoryId")
    List<Book> findByCategoryId(@Param("categoryId") int categoryId);
}
