package com.library.library_spring.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingSaveRequest {
    @NotNull(message= "İsim alani bos veya null olamaz")
    @NotEmpty
    private String name;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private int bookId;
}
