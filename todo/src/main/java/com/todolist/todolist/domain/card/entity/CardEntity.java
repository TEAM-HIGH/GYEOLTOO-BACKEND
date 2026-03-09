package com.todolist.todolist.domain.card.entity;

import com.todolist.todolist.domain.list.entity.ListEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private boolean completed;
    private String emoji;
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private ListEntity todoList;

    private int position;

    public void update(String title, String content, String emoji, boolean completed, LocalDateTime dueDate, int position) {
        this.title = title;
        this.content = content;
        this.emoji = emoji;
        this.completed = completed;
        this.dueDate = dueDate;
        this.position = position;
    }
}