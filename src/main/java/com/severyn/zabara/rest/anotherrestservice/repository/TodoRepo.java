package com.severyn.zabara.rest.anotherrestservice.repository;

import com.severyn.zabara.rest.anotherrestservice.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
