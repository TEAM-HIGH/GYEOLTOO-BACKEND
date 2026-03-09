package com.todolist.todolist.domain.list.dto;

import com.todolist.todolist.domain.list.entity.ListEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class ListRequestDto {
    private String title;

    public ListEntity toEntity(){
        return ListEntity.builder()
                .title(this.title)
                .build();
    }
}