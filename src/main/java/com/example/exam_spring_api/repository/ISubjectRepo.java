package com.example.exam_spring_api.repository;
import com.example.exam_spring_api.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepo extends JpaRepository<Subject, Integer> {
}
