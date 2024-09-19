package org.example.exercice_student.service;

import org.example.exercice_student.dao.StudentRepository;
import org.example.exercice_student.dao.UserRepository;
import org.example.exercice_student.dto.StudentDtoReceive;
import org.example.exercice_student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
//    @Autowired
//    private final UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;

//    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }

    public Student createStudent(StudentDtoReceive studentDtoReceive){
        Student studentCreated = Student.builder()
                .firstname(studentDtoReceive.getFirstname())
                .lastname(studentDtoReceive.getLastname())
                .age(studentDtoReceive.getAge())
                .email(studentDtoReceive.getEmail())
                .photo(studentDtoReceive.getPhoto()).build();
        return studentRepository.save(studentCreated);
    }

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> searchStudents(String search){
        return (List<Student>) studentRepository.findAllByLastname(search);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student updateStudent){
        Student studentExist = getStudentById(id);
        if(studentExist != null){
            studentRepository.save(updateStudent);
        }
        return studentExist;
    }
}
