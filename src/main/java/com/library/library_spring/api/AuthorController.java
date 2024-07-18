package com.library.library_spring.api;

import com.library.library_spring.business.abstracts.IAuthorService;
import com.library.library_spring.core.Result.Result;
import com.library.library_spring.core.Result.ResultData;
import com.library.library_spring.core.Result.ResultHelper;
import com.library.library_spring.core.config.Msg;
import com.library.library_spring.core.exception.NotFoundException;
import com.library.library_spring.core.modelMaper.IModelMapperService;
import com.library.library_spring.dto.AuthorResponse;
import com.library.library_spring.dto.AuthorSaveRequest;
import com.library.library_spring.dto.AuthorUpdateRequest;
import com.library.library_spring.entities.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final IAuthorService authorService;
    private final IModelMapperService modelMapper;

    public AuthorController(IAuthorService authorService, IModelMapperService modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable("id") int id) {
            Author author = authorService.get(id);
            if (author == null) {
                throw new NotFoundException(Msg.NOT_FOUND);
            }
            AuthorResponse authorResponse = modelMapper.forResponse().map(author, AuthorResponse.class);
            return ResultHelper.success(authorResponse);

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {
//        try {
            Author saveAuthor = modelMapper.forRequest().map(authorSaveRequest, Author.class);
            authorService.save(saveAuthor);
            AuthorResponse authorResponse = modelMapper.forResponse().map(saveAuthor, AuthorResponse.class);
            return ResultHelper.created(authorResponse);
//            return new ResultData<>(Msg.CREATED, true, authorResponse);
//        } catch (Exception e) {
//            return ResultHelper.notFoundError(Msg.VALIDATE_ERROR, HttpStatus.BAD_REQUEST);
//        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@PathVariable("id") int id, @Valid @RequestBody AuthorUpdateRequest authorUpdateRequest) {

            Author existingAuthor = authorService.get(id);
            if (existingAuthor == null) {
                throw new NotFoundException(Msg.NOT_FOUND);
            }
            Author updateAuthor = modelMapper.forRequest().map(authorUpdateRequest, Author.class);
            updateAuthor.setId(id);
            authorService.update(updateAuthor);
            AuthorResponse authorResponse = modelMapper.forResponse().map(updateAuthor, AuthorResponse.class);
            return ResultHelper.success(authorResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.authorService.delete(id);
        return ResultHelper.ok();
    }
}
