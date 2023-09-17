package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.exception.StudentNotFoundException;
import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = {"/students"})
    public String displayStudentPage() {
        return "student";
    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/students/list")
    @ResponseBody
    public List<Student> listStudents(@RequestParam(required = false) String keyword) {
        return studentService.listStudents(keyword);
    }

    @PostMapping(value = "/students")
    @ResponseBody
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping(value = "/students/{id}")
    @ResponseBody
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public boolean deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }
}
