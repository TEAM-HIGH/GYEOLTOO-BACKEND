package com.todolist.todolist.domain.user.controller;

import com.todolist.todolist.domain.user.dto.request.UserRequest;
import com.todolist.todolist.domain.user.dto.response.UserResponse;
import com.todolist.todolist.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequestDto) {
        UserResponse userResponse = userService.login(userRequestDto);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserRequest userRequestDto) {
        userService.signup(userRequestDto);
    }
}
