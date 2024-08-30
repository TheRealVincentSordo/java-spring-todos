package com.todos.controller;

import com.todos.db.entity.Todo;
import com.todos.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodoStatus(@PathVariable Long id, @RequestBody Todo todo) {
        Optional<Todo> existingTodo = todoRepository.findById(id);

        if (existingTodo.isPresent()) {
            Todo updatedTodo = existingTodo.get();
            updatedTodo.setCompleted(todo.isCompleted());
            return todoRepository.save(updatedTodo);
        } else {
            throw new RuntimeException("TODO not found with id " + id);
        }
    }
}

