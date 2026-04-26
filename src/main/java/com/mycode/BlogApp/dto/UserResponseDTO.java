package com.mycode.BlogApp.dto;

import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

}
