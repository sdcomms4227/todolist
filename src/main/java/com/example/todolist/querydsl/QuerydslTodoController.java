package com.example.todolist.querydsl;

import com.example.todolist.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/querydsl/todoList")
@RequiredArgsConstructor
@Controller
public class QuerydslTodoController {

    private final QuerydslTodoService queryDslTodoService;

    @GetMapping
    public String select(Model model){
        List<TodoEntity> todoList = queryDslTodoService.findAll();
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

    @PostMapping
    public @ResponseBody
    String insert(@RequestBody List<String> contentList){
        queryDslTodoService.insert(contentList);
        return "ok";
    }

    @PutMapping
    public @ResponseBody
    String update(@RequestBody List<Long> idxList){
        queryDslTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping
    public @ResponseBody
    String delete(@RequestBody List<Long> idxList) {
        queryDslTodoService.delete(idxList);
        return "ok";
    }
}
