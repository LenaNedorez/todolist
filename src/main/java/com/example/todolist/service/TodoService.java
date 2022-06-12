package com.example.todolist.service;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(toDoRepository.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = toDoRepository.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(toDoRepository.save(todo));
    }
}
