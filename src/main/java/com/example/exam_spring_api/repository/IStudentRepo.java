package com.example.exam_spring_api.repository;

import com.example.exam_spring_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
