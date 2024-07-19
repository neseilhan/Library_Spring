package com.library.library_spring.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int Id;

    @NotNull(message = "Kitap ismi boş veya null olamaz.")
    private String name;

    private String publicationYear;

    private int stock;

    private int authorId;

    private int publisherId;

    private List<Integer> categoryId;
}
