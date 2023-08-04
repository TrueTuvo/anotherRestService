package com.severyn.zabara.rest.anotherrestservice.service;

import com.severyn.zabara.rest.anotherrestservice.entity.UserEntity;
import com.severyn.zabara.rest.anotherrestservice.exceptions.UserAlreadyExistException;
import com.severyn.zabara.rest.anotherrestservice.exceptions.UserNotFoundException;
import com.severyn.zabara.rest.anotherrestservice.model.User;
import com.severyn.zabara.rest.anotherrestservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Користувач з таки ім'ям вже існує");
        }
        return userRepo.save(user);
    }

    public UserEntity getOneUser(Long id) throws UserNotFoundException {
        if (userRepo.findById(id).isEmpty()) {
            throw new UserNotFoundException("Користувач з таким ID відсутній");
        }
        return userRepo.findById(id).get();
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }


}
