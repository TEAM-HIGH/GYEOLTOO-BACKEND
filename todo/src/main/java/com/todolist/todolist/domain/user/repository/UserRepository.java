package com.todolist.todolist.domain.user.repository;

import com.todolist.todolist.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
