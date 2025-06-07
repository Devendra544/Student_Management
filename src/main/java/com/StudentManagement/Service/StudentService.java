package com.StudentManagement.Service;

import com.StudentManagement.Model.Student;
import com.StudentManagement.Repository.StudentReposioty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentReposioty studentReposioty;

    public StudentService(StudentReposioty studentReposioty)
    {
        this.studentReposioty=studentReposioty;
    }

    public List<Student> findAllStudents()
    {
        return studentReposioty.findAll();
    }

    public void addStudent(Student student)
    {
        studentReposioty.save(student);
    }

    public void deleteStudent(Long id)
    {
        studentReposioty.deleteById(id);
    }

    public Student findStudentById(Long id)
    {
        return studentReposioty.findById(id).orElseThrow(()->new RuntimeException("Student not Found"));
    }

    public void updateStudent(Student student)
    {
        studentReposioty.save(student);
    }

}
