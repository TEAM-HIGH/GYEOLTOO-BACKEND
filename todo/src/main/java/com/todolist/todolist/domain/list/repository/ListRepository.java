package com.todolist.todolist.domain.list.repository;

import com.todolist.todolist.domain.list.entity.ListEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
