package com.todolist.todolist.domain.list.entity;

import com.todolist.todolist.domain.card.entity.CardEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int position;

    @OneToMany(mappedBy ="todoList", cascade = CascadeType.ALL)
    private List<CardEntity> cards = new ArrayList<>();

    public void UpdateListTitle(String newTitle){
        if(newTitle == null || newTitle.isBlank()){
            throw new IllegalArgumentException("제목은 비어있을 수 없습니다.");
        }
        this.title = newTitle;
    }
}
