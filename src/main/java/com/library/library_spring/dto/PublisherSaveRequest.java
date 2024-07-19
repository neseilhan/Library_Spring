package com.library.library_spring.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherSaveRequest {

    @NotNull(message= "Yayinci adi bos veya null olamaz")
    @NotEmpty
    private String name;

    private String establishmentYear;

    private String address;

}
