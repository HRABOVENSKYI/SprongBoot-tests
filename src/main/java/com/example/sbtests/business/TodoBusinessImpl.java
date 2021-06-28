package com.example.sbtests.business;

import com.example.sbtests.data.TodoService;

import java.util.List;
import java.util.stream.Collectors;

public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {

        List<String> todos = todoService.retrieveTodos(user);

        return todos.stream()
                .filter(todo -> todo.contains("Spring"))
                .collect(Collectors.toList());
    }
}
