package com.mycode.BlogApp.controller;

import com.mycode.BlogApp.dto.CategoryRequestDTO;
import com.mycode.BlogApp.dto.CategoryResponseDTO;
import com.mycode.BlogApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO)
    {
        CategoryResponseDTO categoryResponseDTO = categoryService.createCategory(categoryRequestDTO);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.CREATED);
    }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO)
    {
        CategoryResponseDTO categoryResponseDTO = categoryService.updateCategory(id,categoryRequestDTO);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.ACCEPTED);
    }


    //delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id)
    {
        boolean b = categoryService.deleteCategory(id);
        return new ResponseEntity<>("record deleted successfully", HttpStatus.OK);
    }


    //get single category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id)
    {
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }


    //get all category
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories()
    {
        List<CategoryResponseDTO> categoryResponseDTOList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponseDTOList, HttpStatus.OK);
    }


}
