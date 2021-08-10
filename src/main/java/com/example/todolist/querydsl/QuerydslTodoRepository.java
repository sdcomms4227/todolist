package com.example.todolist.querydsl;

import com.example.todolist.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuerydslTodoRepository extends JpaRepository<TodoEntity, Long>, QuerydslTodoCustomRepository {
}
