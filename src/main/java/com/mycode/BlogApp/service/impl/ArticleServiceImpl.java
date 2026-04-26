package com.mycode.BlogApp.service.impl;

import com.mycode.BlogApp.dto.ArticleRequestDTO;
import com.mycode.BlogApp.dto.ArticleResponseDTO;
import com.mycode.BlogApp.entity.Article;
import com.mycode.BlogApp.entity.Category;
import com.mycode.BlogApp.entity.User;
import com.mycode.BlogApp.exception.ResourceNotFoundException;
import com.mycode.BlogApp.mapper.ArticleMapper;
import com.mycode.BlogApp.repository.ArticleRepository;
import com.mycode.BlogApp.repository.CategoryRepository;
import com.mycode.BlogApp.repository.UserRepository;
import com.mycode.BlogApp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleMapper articleMapper;

    //create
    @Override
    public ArticleResponseDTO createArticle(ArticleRequestDTO articleRequestDTO) {
        Article article = articleMapper.toEntity(articleRequestDTO);

        article.setRating(9.0);
        article.setCreatedAt(LocalDateTime.now());
        article.setPublishedAt(LocalDateTime.now());

        //fetch category
        Category category = categoryRepository.findById(articleRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("category id not found"));
        article.setCategory(category);

        //fetch user
        User user = userRepository.findById(articleRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("user id not found"));
        article.setUser(user);

        Article saved  = articleRepository.save(article);
        return articleMapper.toDto(saved);
    }

    @Override
    public ArticleResponseDTO updateArticle(Long id, ArticleRequestDTO articleRequestDTO) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("article id not found"));
        //made changes here...
        return articleMapper.toDto(article);
    }

    @Override
    public boolean deleteArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("article id not found"));
        articleRepository.delete(article);
        return true;
    }

    @Override
    public ArticleResponseDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("article id not found"));
        return articleMapper.toDto(article);
    }


    @Override
    public List<ArticleResponseDTO> getAllArticles() {

        List<Article> list = articleRepository.findAll();
        return list.stream().map(ob -> articleMapper.toDto(ob)).toList();
    }

    @Override
    public List<ArticleResponseDTO> getArticlesByUserId(Long id) {

        List<Article> list = articleRepository.findByUserId(id);
        return list.stream().map(ob -> articleMapper.toDto(ob)).toList();
    }

    @Override
    public List<ArticleResponseDTO> getArticlesByCategoryId(Long id) {

        List<Article> list = articleRepository.findByCategoryId(id);
        return list.stream().map(ob -> articleMapper.toDto(ob)).toList();
    }


}
