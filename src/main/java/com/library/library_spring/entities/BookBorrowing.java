package com.library.library_spring.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//import java.util.Date;


@Entity
@Table(name = "book_borrowing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id")
    private int id; //It does not have to correspond to the name in the database.

    @NotNull
    @Column(name = "borrower_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date")
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate return_date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowing_book_id")
    private Book book;

}