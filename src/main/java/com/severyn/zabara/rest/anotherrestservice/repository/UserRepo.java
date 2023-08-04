package com.severyn.zabara.rest.anotherrestservice.repository;

import com.severyn.zabara.rest.anotherrestservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);

}
