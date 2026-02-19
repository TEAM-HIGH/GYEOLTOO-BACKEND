package com.todolist.todolist.dto.card;

import java.time.LocalDateTime;

public class CardRequestDto {
    private String title;
    private String content;
    private String emoji;
    private boolean completed;
    private LocalDateTime dueDate;
}
