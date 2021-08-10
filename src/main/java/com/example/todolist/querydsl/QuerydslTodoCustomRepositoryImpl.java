package com.example.todolist.querydsl;

import com.example.todolist.entity.TodoEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// Gradle > Tasks > other > compileQuerydsl 수동실행 후
// todoEntity import
import static com.example.todolist.entity.QTodoEntity.todoEntity;

@RequiredArgsConstructor
@Repository
public class QuerydslTodoCustomRepositoryImpl implements QuerydslTodoCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TodoEntity> findAllByDeleteYn(String deleteYn) {
        JPAQuery<TodoEntity> query = jpaQueryFactory
                .select(todoEntity)
                .from(todoEntity)
                .where(todoEntity.deleteYn.eq(deleteYn));
        return query.fetch();
    }

    @Override
    public TodoEntity findByIdxAndDeleteYn(Long idx, String deleteYn) {
        JPAQuery<TodoEntity> query = jpaQueryFactory
                .select(todoEntity)
                .from(todoEntity)
                .where(todoEntity.idx.eq(idx).and(todoEntity.deleteYn.eq(deleteYn)));
        return query.fetchOne();
    }
}
