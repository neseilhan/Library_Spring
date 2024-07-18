package com.library.library_spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    private int Id;

    private String name;

    private String publicationYear;

    private int stock;

    private int authorId;

    private int publisherId;

    private List<Integer> categoryId;
}
