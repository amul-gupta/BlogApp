package com.mycode.BlogApp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;
    private String content;

    private Boolean paid;
    private Double price;
    private Double rating;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

}
