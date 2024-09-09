package org.example.spring_exo01.controller;

import org.example.spring_exo01.model.Todo;
import org.example.spring_exo01.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;
    private Todo todo;
    private List<Todo> todoList = List.of(new Todo("exemple1","un exemple","fini"), new Todo("exemple2","un exemple","En cours"));

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String home(){
        return "/todo/home";
    }

    @RequestMapping("/getOneTodo")
    public String getOneTodo(Model model){
        model.addAttribute("todo", todoList.get(1));
        return "/todo/getOneTodo";
    }

    @RequestMapping("/getAllTodos")
    @ResponseBody
    public List<Todo> getAllTodos(){
        return todoList;
    }

}
