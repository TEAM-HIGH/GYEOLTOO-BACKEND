package com.todolist.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int position;

    public void UpdateListTitle(String newTitle){
        if(newTitle == null || newTitle.isBlank()){
            throw new IllegalArgumentException("제목은 비어있을 수 없습니다.");
        }
        this.title = newTitle;
    }
}
