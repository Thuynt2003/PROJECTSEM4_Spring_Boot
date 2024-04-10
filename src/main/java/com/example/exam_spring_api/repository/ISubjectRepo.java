package com.example.exam_spring_api.repository;

import com.example.exam_EAD_sem4.entity.Subject_t;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepo extends JpaRepository<Subject_t, Integer> {
}
