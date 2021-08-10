package com.example.todolist.jpa;

import com.example.todolist.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findAllByDeleteYn(String deleteYn);
    TodoEntity findByIdxAndDeleteYn(Long idx, String deleteYn);
}
