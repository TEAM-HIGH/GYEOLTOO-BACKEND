package com.todolist.todolist.domain.card.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.todolist.todolist.domain.card.entity.CardEntity;
import com.todolist.todolist.domain.list.entity.ListEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CardRequestDto {
    private String title;
    private String content;
    private String emoji;
    private boolean completed;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dueDate;
    private int position;

    public CardEntity toEntity(ListEntity listEntity) {
        return CardEntity.builder()
                .title(this.title)
                .content(this.content)
                .completed(this.completed)
                .emoji(this.emoji)
                .dueDate(this.dueDate)
                .todoList(listEntity)
                .position(this.position)
                .build();
    }
}
