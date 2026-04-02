package com.todolist.todolist.domain.board.entity;

import com.todolist.todolist.domain.list.entity.ListEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<ListEntity> list = new ArrayList<>();

    public BoardEntity UpdateBoard(BoardEntity boardEntity){
        BoardEntity.builder()
                    .title(boardEntity.getTitle());
        return boardEntity;
    }
}
