//package org.example.exercice_student.controller;
//
//import org.example.exercice_student.entity.User;
//import org.example.exercice_student.service.AuthService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/user/")
//public class AuthController {
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @GetMapping("/registration")
//    public String inscription(Model model){
//        model.addAttribute("user", new User());
//        return "registration-form";
//    }
//
//    @PostMapping("/registration")
//    public String inscriptionForm(@ModelAttribute("user") User user){
//        authService.register(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/login")
//    public String connexion(Model model){
//        return "connexion-form";
//    }
//
//    @PostMapping("/login")
//    public String connexionForm(@ModelAttribute("username") String username, @ModelAttribute("password") String password){
//        boolean connected = authService.login(username, password);
//        if(connected){
//            return "redirect:/";
//        }
//        return "redirect:/login";
//    }
//}