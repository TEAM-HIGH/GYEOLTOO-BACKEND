package com.todolist.todolist.repository.list;

import com.todolist.todolist.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
