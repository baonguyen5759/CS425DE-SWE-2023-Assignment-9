package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.exception.StudentNotFoundException;
import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService() {}

    public Student getStudent(long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(String.format("Student ID [%d] is not found.", id)));
    }

    public List<Student> listStudents(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return this.studentRepository.findAll();
        } else {
            String searchKeyword = '%' + keyword + '%';
            return this.studentRepository.findByStudentNumberLikeOrFirstNameLikeIgnoreCaseOrMiddleNameLikeIgnoreCaseOrLastNameLikeIgnoreCase(searchKeyword, searchKeyword, searchKeyword, searchKeyword);
        }
    }

    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student updateStudent(long id, Student newStudent) {
        return this.studentRepository.findById(id)
                .map(student -> {
                    student.setStudentNumber(newStudent.getStudentNumber());
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setMiddleName(newStudent.getMiddleName());
                    student.setCgpa(newStudent.getCgpa());
                    student.setDateOfEnrollment(newStudent.getDateOfEnrollment());
                    student.setIsInternational(newStudent.getIsInternational());
                    return this.studentRepository.save(student);
                })
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student ID [%d] is not found", id)));
    }

    public boolean deleteStudent(long id) {
        Optional<Student> optStudent = this.studentRepository.findById(id);
        if (optStudent.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }
        throw new StudentNotFoundException(String.format("Student ID [%d]  is not found", id));
    }
}
