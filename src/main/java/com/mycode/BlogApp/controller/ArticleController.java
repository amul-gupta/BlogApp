package com.mycode.BlogApp.controller;

import com.mycode.BlogApp.dto.ArticleRequestDTO;
import com.mycode.BlogApp.dto.ArticleResponseDTO;
import com.mycode.BlogApp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //create
    @PostMapping
    ResponseEntity<ArticleResponseDTO> createArticle(@RequestBody ArticleRequestDTO articleRequestDTO)
    {
        ArticleResponseDTO articleResponseDTO = articleService.createArticle(articleRequestDTO);
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{id}")
    ResponseEntity<ArticleResponseDTO> updateArticle(@PathVariable Long id,@RequestBody ArticleRequestDTO articleRequestDTO)
    {
        ArticleResponseDTO articleResponseDTO = articleService.updateArticle(id,articleRequestDTO);
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.ACCEPTED);
    }

    //delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteArticle(@PathVariable Long id)
    {
        boolean b = articleService.deleteArticle(id);
        return new ResponseEntity<>("record deleted successfully", HttpStatus.OK);
    }


    //get single article
    @GetMapping("/{id}")
    ResponseEntity<ArticleResponseDTO> getArticleById(@PathVariable Long id)
    {
        ArticleResponseDTO articleResponseDTO = articleService.getArticleById(id);
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.OK);
    }


    //get all
    @GetMapping
    ResponseEntity<List<ArticleResponseDTO>> getAllArticles()
    {
        List<ArticleResponseDTO> articleResponseDTO = articleService.getAllArticles();
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.OK);
    }


    //get articles of any user
    @GetMapping("/users/{id}")
    ResponseEntity<List<ArticleResponseDTO>> getArticlesByUserId(@PathVariable Long id)
    {
        List<ArticleResponseDTO> articleResponseDTO = articleService.getArticlesByUserId(id);
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.OK);
    }

    //get articles of any category
    @GetMapping("/categories/{id}")
    ResponseEntity<List<ArticleResponseDTO>> getArticlesByCategoryId(@PathVariable Long id)
    {
        List<ArticleResponseDTO> articleResponseDTO = articleService.getArticlesByCategoryId(id);
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.OK);
    }

}
