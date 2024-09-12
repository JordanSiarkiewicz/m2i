package org.example.exercice_student.controller;

import jakarta.validation.Valid;
import org.example.exercice_student.dao.StudentRepository;
import org.example.exercice_student.model.Student;
import org.example.exercice_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/formulaire")
    public String formAddStudent(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        studentService.save(student);
        return "redirect:/";
    }

    @RequestMapping("/students") // /students?search=Toto
    public String showStudents(@RequestParam(name = "search", required = false) String search, Model model){
        model.addAttribute("students", studentService.findAll());
        return "list";
    }

    @RequestMapping("/searchStudent") // /students?search=Toto
    public String searchStudents(@RequestParam(name = "searchStudent", required = false) String search, Model model){
        if (search != null && !search.isEmpty()) {
            model.addAttribute("students", studentRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(search, search));
        } else {
            model.addAttribute("students", studentService.findAll());
        }
        return "list";
    }

    @RequestMapping("/student/{id}")
    public String showStudent(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.findById(id));
        return "detail";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Long id){
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

    @RequestMapping("/update")
    public String formUpdate(@RequestParam("studentId") Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        studentService.save(student);
        return "form";
    }
}
