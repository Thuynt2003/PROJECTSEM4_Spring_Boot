package com.example.exam_spring_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id ;
    @Column(unique = false)
    private String subject_code;
    @Column(unique = false)
    private String subject_name;
    private int credit;


}
