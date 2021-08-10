package com.example.todolist.querydsl;

import com.example.todolist.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuerydslTodoService {

    private final QuerydslTodoRepository queryDslTodoRepository;

    public List<TodoEntity> findAll() {
        return queryDslTodoRepository.findAllByDeleteYn("N");
    }

    @Transactional
    public void insert(List<String> stringList) {
        stringList.forEach(content -> {
            TodoEntity todoEntity = TodoEntity.builder()
                    .content(content)
                    .doneYn("N")
                    .deleteYn("N")
                    .build();
            queryDslTodoRepository.save(todoEntity);
        });
    }

    @Transactional
    public void changeDone(List<Long> idxList) {
        idxList.forEach(idx -> {
            TodoEntity todoEntity = queryDslTodoRepository.findByIdxAndDeleteYn(idx, "N");
            todoEntity.setDoneYn("Y".equals(todoEntity.getDoneYn()) ? "N" : "Y");
        });
    }

    @Transactional
    public void delete(List<Long> idxList) {
        idxList.forEach(idx -> {
            TodoEntity todoEntity = queryDslTodoRepository.findByIdxAndDeleteYn(idx, "N");
            todoEntity.setDeleteYn("Y");
        });
    }
}
