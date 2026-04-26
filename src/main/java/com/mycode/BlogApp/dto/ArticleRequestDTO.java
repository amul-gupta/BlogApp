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
public class ArticleRequestDTO {


    private String title;
    private String shortDescription;
    private String content;

    private Boolean paid;
    private Double price;
    private Status status;

    private Long categoryId;
    private Long userId;

}
