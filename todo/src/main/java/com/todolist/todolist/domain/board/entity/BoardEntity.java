package com.todolist.todolist.domain.board.entity;

import com.todolist.todolist.domain.list.entity.ListEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<ListEntity> list = new ArrayList<>();
}
