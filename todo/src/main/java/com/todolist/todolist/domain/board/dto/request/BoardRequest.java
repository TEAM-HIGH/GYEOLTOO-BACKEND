package com.todolist.todolist.domain.board.dto.request;

import com.todolist.todolist.domain.board.entity.BoardEntity;
import lombok.Getter;

@Getter
public class BoardRequest {
    private String title;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
            .title(this.title)
            .build();
    }
}