package com.mycode.BlogApp.mapper;

import com.mycode.BlogApp.dto.ArticleRequestDTO;
import com.mycode.BlogApp.dto.ArticleResponseDTO;
import com.mycode.BlogApp.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public  ArticleResponseDTO toDto(Article article)
    {
        return ArticleResponseDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .shortDescription(article.getShortDescription())
                .content(article.getContent())
                .paid(article.getPaid())
                .price(article.getPrice())
                .rating(article.getRating())
                .status(article.getStatus())
                .publishedAt(article.getPublishedAt())
                .createdAt(article.getCreatedAt())
                .username(article.getUser().getUsername())
                .categoryName(article.getCategory().getName())
                .build();
    }

    public Article toEntity(ArticleRequestDTO articleRequestDTO)
    {
          return Article.builder()
                  .title(articleRequestDTO.getTitle())
                  .shortDescription(articleRequestDTO.getShortDescription())
                  .content(articleRequestDTO.getContent())
                  .paid(articleRequestDTO.getPaid())
                  .price(articleRequestDTO.getPrice())
                  .status(articleRequestDTO.getStatus())
                  .build();
    }
}
