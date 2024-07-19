package com.library.library_spring.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int Id;

    private String name;

    private String establishmentYear;

    private String address;
}
