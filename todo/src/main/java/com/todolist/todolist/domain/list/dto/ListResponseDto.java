package com.todolist.todolist.domain.list.dto;

import com.todolist.todolist.domain.list.entity.ListEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListResponseDto {
    Long id;
    String title;

    public static ListResponseDto from(ListEntity listEntity) {
        return new ListResponseDto(
                listEntity.getId(),
                listEntity.getTitle()
        );
    }
}
