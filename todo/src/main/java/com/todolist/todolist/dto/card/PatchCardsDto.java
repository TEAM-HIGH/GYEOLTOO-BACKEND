package com.todolist.todolist.dto.card;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PatchCardsDto {
    private String title;
    private String content;
    private String emoji;
    private boolean completed;
    private LocalDateTime dueDate;
}
