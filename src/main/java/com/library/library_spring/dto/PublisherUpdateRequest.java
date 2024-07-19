package com.library.library_spring.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherUpdateRequest {

    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int publisherId;

    @NotNull(message = "Yayinci ismi boş veya null olamaz.")
    private String name;

    private String establishmentYear;

    private String address;
}
