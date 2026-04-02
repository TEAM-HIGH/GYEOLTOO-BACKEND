package com.todolist.todolist.domain.board.dto.response;

import com.todolist.todolist.domain.board.entity.BoardEntity;
import com.todolist.todolist.domain.card.dto.CardResponseDto;
import com.todolist.todolist.domain.list.dto.ListResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponse {
    private Long id;
    private String title;
    private List<ListResponseDto> lists;

    public static BoardResponse from(BoardEntity boardEntity) {
        return BoardResponse.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .lists(boardEntity.getList().stream()
                        .map(ListResponseDto::from)
                        .collect(Collectors.toList()))
                .build();
    }
}
