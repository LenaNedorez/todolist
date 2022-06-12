package com.example.todolist.controller;

import com.example.todolist.entity.UserEntity;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userRepository.save(user);
            return ResponseEntity.ok("Пользователь был успешно сохранен.");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getUsers () {
        try {
            return ResponseEntity.ok("Сервер работает.");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
