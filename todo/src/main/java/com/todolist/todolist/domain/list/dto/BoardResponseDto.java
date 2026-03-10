package com.todolist.todolist.domain.list.dto;

import com.todolist.todolist.domain.card.dto.CardResponseDto;
import com.todolist.todolist.domain.list.entity.ListEntity;
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
public class BoardResponseDto {
    private Long id;
    private String title;
    private List<CardResponseDto> cards;

    public static BoardResponseDto from(ListEntity listEntity) {
        return BoardResponseDto.builder()
                .id(listEntity.getId())
                .title(listEntity.getTitle())
                .cards(listEntity.getCards().stream()
                        .map(CardResponseDto::from)
                        .collect(Collectors.toList()))
                .build();
    }
}
