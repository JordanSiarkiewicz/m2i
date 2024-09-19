package org.example.exercice_student.controller;

import org.example.exercice_student.dto.StudentDtoReceive;
import org.example.exercice_student.dto.StudentDtoSend;
import org.example.exercice_student.entity.Student;
import org.example.exercice_student.service.AuthService;
import org.example.exercice_student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/student/")
public class StudentController {
    private String location = "src/main/resources/static/image";
    private final StudentService studentService;
    private final AuthService authService;

    public StudentController(StudentService studentService, AuthService authService) {
        this.studentService = studentService;
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDtoSend>> getData() {
        List<Student> students = studentService.getAllStudents();
        List<StudentDtoSend> studentDtoSends = new ArrayList<>();
        for (Student student : students) {
            studentDtoSends.add(new StudentDtoSend(student.getId(), student.getFirstname(), student.getLastname(), student.getAge(), student.getEmail(), student.getPhoto()));
        }

        return ResponseEntity.ok(studentDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDtoSend> getDataById(@PathVariable("id") long id) {
        Student student = studentService.getStudentById(id);
        StudentDtoSend studentDtoSend = new StudentDtoSend(student.getId(), student.getFirstname(), student.getLastname(), student.getAge(), student.getEmail(), student.getPhoto());
        return ResponseEntity.ok(studentDtoSend);
    }

    @PostMapping
    public ResponseEntity<StudentDtoSend> registerStudent(@Validated @RequestBody StudentDtoReceive studentDtoReceive) {
        Student student = studentService.createStudent(studentDtoReceive);
        StudentDtoSend studentDtoSend = new StudentDtoSend(student.getId(), student.getFirstname(), student.getLastname(), student.getAge(), student.getEmail(), student.getPhoto());
        return new ResponseEntity<>(studentDtoSend, HttpStatus.CREATED);
    }
}
