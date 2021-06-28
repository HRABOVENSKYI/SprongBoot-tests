package com.example.sbtests.business;

import com.example.sbtests.data.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoBusinessImplTest {

    @Mock
    private TodoService todoService;

    @Test
    void retrieveTodosRelatedToSpring() {

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
        when(todoService.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }

    @Test
    void retrieveTodosRelatedToSpringWithEmptyList() {

        List<String> todos = Collections.emptyList();
        when(todoService.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());
    }
}