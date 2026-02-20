package com.todolist.todolist.dto.card;

import com.todolist.todolist.entity.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDto {
    private Long id;
    private String title;
    private boolean completed;
    private String emoji;

    public static CardResponseDto from(CardEntity cardEntity) {
        return new CardResponseDto(
                cardEntity.getId(),
                cardEntity.getTitle(),
                cardEntity.isCompleted(),
                cardEntity.getEmoji()
        );
    }
}
