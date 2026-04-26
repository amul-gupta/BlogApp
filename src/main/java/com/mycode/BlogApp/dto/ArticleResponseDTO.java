package com.mycode.BlogApp.dto;


import com.mycode.BlogApp.entity.Category;
import com.mycode.BlogApp.entity.Status;
import com.mycode.BlogApp.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleResponseDTO {

    private Long id;

    private String title;
    private String shortDescription;
    private String content;

    private Boolean paid;
    private Double price;
    private Double rating;

    private Status status;

    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;

    private String username;
    private String categoryName;
}
