package com.StudentManagement.Repository;

import com.StudentManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReposioty extends JpaRepository<Student,Long> {

}
