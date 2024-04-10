package com.example.exam_spring_api.repository;
import com.example.exam_spring_api.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudent_scoreRepo extends JpaRepository<Score, Integer> {
}
