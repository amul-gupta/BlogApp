package com.mycode.BlogApp.service.impl;

import com.mycode.BlogApp.dto.CategoryRequestDTO;
import com.mycode.BlogApp.dto.CategoryResponseDTO;
import com.mycode.BlogApp.entity.Category;
import com.mycode.BlogApp.exception.ResourceNotFoundException;
import com.mycode.BlogApp.mapper.CategoryMapper;
import com.mycode.BlogApp.repository.CategoryRepository;
import com.mycode.BlogApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toEntity(categoryRequestDTO);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        Category category= categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category id not found"));
        category.setName(categoryRequestDTO.getName());
        return categoryMapper.toDto(category);
    }

    @Override
    public boolean deleteCategory(Long id) {
        Category category= categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category id not found"));
        categoryRepository.delete(category);
        return true;
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category= categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category id not found"));
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(ob-> categoryMapper.toDto(ob)).toList();
    }
}
