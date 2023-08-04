package com.severyn.zabara.rest.anotherrestservice.model;

import com.severyn.zabara.rest.anotherrestservice.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private boolean completed;
    private String description;

    public Todo() {
    }

    public Todo(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public static Todo toModel(TodoEntity todoEntity){
        Todo model = new Todo();
        model.setId(todoEntity.getId());
        model.setTitle(todoEntity.getTitle());
        model.setCompleted(todoEntity.getCompleted());
        return model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
