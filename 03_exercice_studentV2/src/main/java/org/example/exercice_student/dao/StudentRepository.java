package org.example.exercice_student.dao;

import org.example.exercice_student.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long> {
    List<Student> findAllByLastname(String search);
    List<Student> findAllByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(String firstname, String lastname);
}
