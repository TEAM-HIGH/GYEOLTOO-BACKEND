package com.todolist.todolist.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    private String accessToken;
    private String refreshToken;
}
