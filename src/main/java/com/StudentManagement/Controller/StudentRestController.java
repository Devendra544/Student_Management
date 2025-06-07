package com.StudentManagement.Controller;

import com.StudentManagement.Model.Student;
import com.StudentManagement.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.findAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return student;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id)
    {
        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student)
    {
        student.setId(id);
        studentService.updateStudent(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
    }
}
