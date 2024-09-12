package org.example.exercice_student.dao;

import org.example.exercice_student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFirstnameAndLastname(String firstname, String lastname);
    Student findByFirstname(String firstname);
    Student findByLastname(String lastname);
    List<Student> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String firstname, String lastname);
}
