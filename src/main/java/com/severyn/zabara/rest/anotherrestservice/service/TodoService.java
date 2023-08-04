package com.severyn.zabara.rest.anotherrestservice.service;

import com.severyn.zabara.rest.anotherrestservice.entity.TodoEntity;
import com.severyn.zabara.rest.anotherrestservice.entity.UserEntity;
import com.severyn.zabara.rest.anotherrestservice.model.Todo;
import com.severyn.zabara.rest.anotherrestservice.repository.TodoRepo;
import com.severyn.zabara.rest.anotherrestservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    @Autowired
    UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }

    public Todo completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());

        return Todo.toModel(todoRepo.save(todo));


    }
}
