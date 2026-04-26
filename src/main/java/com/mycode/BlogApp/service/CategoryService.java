package com.mycode.BlogApp.service;

import com.mycode.BlogApp.dto.CategoryRequestDTO;
import com.mycode.BlogApp.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    //create
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);

    //update
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO);


    //delete
    public boolean deleteCategory(Long id);


    //get single category by id
    public CategoryResponseDTO getCategoryById(Long id);


    //get all category
    public List<CategoryResponseDTO> getAllCategories();
}
