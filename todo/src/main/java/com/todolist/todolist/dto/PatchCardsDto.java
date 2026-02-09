package com.todolist.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatchCardsDto {
    private String title;
    private String content;
    private String emoji;
    private boolean completed;
    private LocalDateTime dueDate;
}
