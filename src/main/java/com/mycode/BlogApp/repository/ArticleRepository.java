package com.mycode.BlogApp.repository;

import com.mycode.BlogApp.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


    List<Article> findByCategoryId(Long id);

    List<Article> findByUserId(Long id);
}
