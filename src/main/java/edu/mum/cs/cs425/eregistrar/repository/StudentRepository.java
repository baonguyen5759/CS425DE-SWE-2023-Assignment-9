package edu.mum.cs.cs425.eregistrar.repository;

import edu.mum.cs.cs425.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentNumberLikeOrFirstNameLikeIgnoreCaseOrMiddleNameLikeIgnoreCaseOrLastNameLikeIgnoreCase(String studentNumber, String firstName, String middleName, String lastName);

    Student findByStudentNumber(String number);

}

