package com.StudentManagement.Controller;

import com.StudentManagement.Model.Student;
import com.StudentManagement.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/students")
    public String displayStudent(Model model)
    {
        model.addAttribute("students",studentService.findAllStudents());
        model.addAttribute("student",new Student());
        return "students";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student)
    {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentDetails(@PathVariable Long id,Model model)
    {
        Student student=studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "editStudent";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student)
    {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
}
