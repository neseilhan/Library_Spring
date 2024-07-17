package com.library.library_spring.core.modelMaper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
