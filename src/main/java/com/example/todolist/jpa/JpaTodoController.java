package com.example.todolist.jpa;

import com.example.todolist.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/jpa/todoList")
@RequiredArgsConstructor
@Controller
public class JpaTodoController {

    private final JpaTodoService jpaTodoService;

    @GetMapping
    public String select(Model model){
        List<TodoEntity> todoList = jpaTodoService.findAll();
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

    @PostMapping
    public @ResponseBody
    String insert(@RequestBody List<String> contentList){
        jpaTodoService.insert(contentList);
        return "ok";
    }

    @PutMapping
    public @ResponseBody
    String update(@RequestBody List<Long> idxList){
        jpaTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping
    public @ResponseBody
    String delete(@RequestBody List<Long> idxList) {
        jpaTodoService.delete(idxList);
        return "ok";
    }
}
