package com.todolist.todolist.repository.card;

import com.todolist.todolist.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
}
