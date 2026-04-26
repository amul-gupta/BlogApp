package com.mycode.BlogApp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {

    private String username;
    private String token;

}
