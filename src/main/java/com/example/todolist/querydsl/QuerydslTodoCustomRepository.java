package com.example.todolist.querydsl;

import com.example.todolist.entity.TodoEntity;

import java.util.List;

public interface QuerydslTodoCustomRepository {

    List<TodoEntity> findAllByDeleteYn(String deleteYn);

    TodoEntity findByIdxAndDeleteYn(Long idx, String deleteYn);
}
