package com.mycode.BlogApp.mapper;

import com.mycode.BlogApp.dto.CategoryRequestDTO;
import com.mycode.BlogApp.dto.CategoryResponseDTO;
import com.mycode.BlogApp.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO categoryRequestDTO)
    {
        return Category.builder()
                .name(categoryRequestDTO.getName())
                .build();
    }

    public CategoryResponseDTO toDto(Category category)
    {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
