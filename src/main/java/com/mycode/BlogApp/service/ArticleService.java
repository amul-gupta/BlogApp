package com.mycode.BlogApp.service;

import com.mycode.BlogApp.dto.ArticleRequestDTO;
import com.mycode.BlogApp.dto.ArticleResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {


    //create
    ArticleResponseDTO createArticle(ArticleRequestDTO articleRequestDTO);

    //update
    ArticleResponseDTO updateArticle(Long id, ArticleRequestDTO articleRequestDTO);

    //delete
    boolean deleteArticle(Long id);

    //get single article
    ArticleResponseDTO getArticleById(Long id);

    //get all
    List<ArticleResponseDTO> getAllArticles();

    //get article of any user
    List<ArticleResponseDTO> getArticlesByUserId(Long id);

    //get article of any category
    List<ArticleResponseDTO> getArticlesByCategoryId(Long id);

}
