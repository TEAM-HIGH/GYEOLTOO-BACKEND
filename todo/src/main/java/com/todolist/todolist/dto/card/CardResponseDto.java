package com.todolist.todolist.dto.card;

import com.todolist.todolist.entity.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String emoji;
    private boolean completed;
    private LocalDateTime dueDate;
    private int position;

    public static CardResponseDto from(CardEntity cardEntity) {
        return new CardResponseDto(
                cardEntity.getId(),
                cardEntity.getTitle(),
                cardEntity.getContent(),
                cardEntity.getEmoji(),
                cardEntity.isCompleted(),
                cardEntity.getDueDate(),
                cardEntity.getPosition()
        );
    }
}