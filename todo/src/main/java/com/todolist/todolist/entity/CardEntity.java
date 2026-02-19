package com.todolist.todolist.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String emoji;

    private LocalDateTime dueAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private ListEntity todoList;

    private int position;
}
