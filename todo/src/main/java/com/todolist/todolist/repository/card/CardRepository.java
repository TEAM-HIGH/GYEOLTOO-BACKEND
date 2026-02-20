package com.todolist.todolist.repository.card;

import com.todolist.todolist.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
    List<CardEntity> findAllByTodoListId(Long listid);
}
