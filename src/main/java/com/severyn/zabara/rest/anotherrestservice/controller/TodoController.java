package com.severyn.zabara.rest.anotherrestservice.controller;

import com.severyn.zabara.rest.anotherrestservice.entity.TodoEntity;
import com.severyn.zabara.rest.anotherrestservice.model.Todo;
import com.severyn.zabara.rest.anotherrestservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id, @RequestBody Todo todo) {
        try {
            return ResponseEntity.ok(todoService.updateTodo(id,todo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

}
