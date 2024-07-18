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
public class AuthorSaveRequest {

    @NotNull(message= "Yazar adi bos veya null olamaz")
    @NotEmpty
    private String name;

    private LocalDate birthDate; //String degil LocalDate yapıldı.

    private String country;
}
