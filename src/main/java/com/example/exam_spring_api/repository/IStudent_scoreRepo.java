package com.example.exam_spring_api.repository;

import com.example.exam_EAD_sem4.entity.Student_score_t;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudent_scoreRepo extends JpaRepository<Student_score_t, Integer> {
}
