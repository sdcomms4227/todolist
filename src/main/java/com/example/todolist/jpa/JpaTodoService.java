package com.example.todolist.jpa;

import com.example.todolist.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JpaTodoService {

    private final JpaTodoRepository jpaTodoRepository;

    public List<TodoEntity> findAll() {
        return jpaTodoRepository.findAllByDeleteYn("N");
    }

    @Transactional
    public void insert(List<String> stringList) {
        stringList.forEach(content -> {
            TodoEntity todoEntity = TodoEntity.builder()
                    .content(content)
                    .doneYn("N")
                    .deleteYn("N")
                    .build();
            jpaTodoRepository.save(todoEntity);
        });
    }

    @Transactional
    public void changeDone(List<Long> idxList) {
        idxList.forEach(idx -> {
           TodoEntity todoEntity = jpaTodoRepository.findByIdxAndDeleteYn(idx, "N");
           todoEntity.setDoneYn("Y".equals(todoEntity.getDoneYn()) ? "N" : "Y");
        });
    }

    @Transactional
    public void delete(List<Long> idxList) {
        idxList.forEach(idx -> {
           TodoEntity todoEntity = jpaTodoRepository.findByIdxAndDeleteYn(idx, "N");
           todoEntity.setDeleteYn("Y");
        });
    }
}
