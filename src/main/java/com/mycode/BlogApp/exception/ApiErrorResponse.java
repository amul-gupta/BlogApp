package com.mycode.BlogApp.exception;

import lombok.*;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;

}
