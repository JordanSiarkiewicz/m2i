package org.example.exercice_student.service;

import org.example.exercice_student.dao.StudentRepository;
import org.example.exercice_student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }





//    private List<Student> students = new ArrayList<>();
//    private StudentRepository studentRepository;
//    private Long currentId = 1L;
//
//    public StudentService(){
//        Student student = new Student(currentId++, "Toto", "Doe", 25, "toto@email.fr");
//        students.add(student);
//    }
//
//    public Student createStudent(Student student){
//        student.setId(currentId++);
//        students.add(student);
//        return student;
//        return studentRepository.save(student);
//    }
//
//    public List<Student> getAllStudents(){
//
//        return students;
//    }
//
//    public Student getStudentById(Long id){
//        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public List<Student> searchStudents(String search){
//        return students.stream().filter(student -> student.getLastname().toLowerCase().contains(search.toLowerCase())).toList();
//    }
//
//    public void deleteStudent(Long id){
//
//        students.removeIf(student -> student.getId().equals(id));
//    }
//
//    public Student updateStudent(Long id, Student updateStudent){
//        Student studentExist = getStudentById(id);
//        if(studentExist != null){
//            studentExist.setFirstname(updateStudent.getFirstname());
//            studentExist.setLastname(updateStudent.getLastname());
//            studentExist.setAge(updateStudent.getAge());
//            studentExist.setEmail(updateStudent.getEmail());
//        }
//        return studentExist;
//    }
}