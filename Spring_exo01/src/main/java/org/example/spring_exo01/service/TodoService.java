package org.example.spring_exo01.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public String getOneTodo(){
        return "Hello World";
    }

    public List<String> getAllTodos(){
        return null;
    }

}
