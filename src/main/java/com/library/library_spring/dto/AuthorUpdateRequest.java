package com.library.library_spring.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;

    @NotNull(message = "Yazar ismi bos veya null olamaz.")
    private String name;

}
