package com.todolist.todolist.domain.board.entity;

import com.todolist.todolist.domain.list.entity.ListEntity;
import com.todolist.todolist.domain.user.entity.UserEntity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Builder.Default
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<ListEntity> list = new ArrayList<>();

    public BoardEntity UpdateBoard(BoardEntity boardEntity){
        BoardEntity.builder()
                    .title(boardEntity.getTitle());
        return boardEntity;
    }
}
