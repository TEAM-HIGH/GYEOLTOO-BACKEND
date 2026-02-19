package com.todolist.todolist.dto.list;

import com.todolist.todolist.entity.ListEntity;
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