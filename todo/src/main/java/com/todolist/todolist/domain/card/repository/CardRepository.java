package com.todolist.todolist.domain.card.repository;

import com.todolist.todolist.domain.card.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
    List<CardEntity> findAllByTodoListId(Long listid);
}
