package com.severyn.zabara.rest.anotherrestservice.controller;


import com.severyn.zabara.rest.anotherrestservice.entity.UserEntity;
import com.severyn.zabara.rest.anotherrestservice.exceptions.UserAlreadyExistException;
import com.severyn.zabara.rest.anotherrestservice.exceptions.UserNotFoundException;
import com.severyn.zabara.rest.anotherrestservice.model.User;
import com.severyn.zabara.rest.anotherrestservice.repository.UserRepo;
import com.severyn.zabara.rest.anotherrestservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Сервер працює");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }

    }


    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {

            userService.registration(user);
            return ResponseEntity.ok("Користувач був успішно збережений");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping()
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            UserEntity user = userService.getOneUser(id);
            return ResponseEntity.ok(User.toModel(user));
        } catch (UserNotFoundException userNotFoundException) {
            return ResponseEntity.badRequest().body(userNotFoundException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

}
