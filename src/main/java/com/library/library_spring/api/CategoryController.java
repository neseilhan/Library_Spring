package com.library.library_spring.api;

import com.library.library_spring.business.abstracts.ICategoryService;
import com.library.library_spring.core.Result.ResultData;
import com.library.library_spring.core.modelMaper.IModelMapperService;
import com.library.library_spring.dto.CategoryResponse;
import com.library.library_spring.dto.CategorySaveRequest;
import com.library.library_spring.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    /*
{
"success" : true,
"message" : "Veri kayit edildi."
"code" : "201",
"data" : {
    {
"id": 2,
"name": "Test Kategorisi"
}
}
}
 */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class);
        return new ResultData<>("201", "Veri eklendi.",true , categoryResponse);
    }
}
