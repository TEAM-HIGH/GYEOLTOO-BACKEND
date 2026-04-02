package com.todolist.todolist.domain.board.repository;

import com.todolist.todolist.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
    @EntityGraph(attributePaths = {"list, list.cards"}) // boards 리스트를 즉시 로딩(JOIN)해서 가져옴
    List<BoardEntity> findAll();
}
