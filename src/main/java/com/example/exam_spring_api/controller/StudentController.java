package com.example.exam_spring_api.controller;


import com.example.exam_EAD_sem4.dto.RequestStudentScore;
import com.example.exam_EAD_sem4.entity.Student_score_t;
import com.example.exam_EAD_sem4.entity.Student_t;
import com.example.exam_EAD_sem4.entity.Subject_t;
import com.example.exam_EAD_sem4.repository.IStudentRepo;
import com.example.exam_EAD_sem4.repository.IStudent_scoreRepo;
import com.example.exam_EAD_sem4.repository.ISubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private IStudentRepo _iStudentRepo;
    @Autowired
    private IStudent_scoreRepo _iStudentScoreRepo;
    @Autowired
    private ISubjectRepo _iSubjectRepo;

    @GetMapping("/getall/student")
    private ResponseEntity<?> getListStudent(){
        return ResponseEntity.ok( _iStudentRepo.findAll() ) ;
    }

    @GetMapping("/getall/score")
    private ResponseEntity<?> getListScore(){
        return ResponseEntity.ok( _iStudentScoreRepo.findAll() ) ;
    }

    @GetMapping("/getall/subject")
    private ResponseEntity<?> getListSubject(){
        return ResponseEntity.ok( _iSubjectRepo.findAll() ) ;
    }

    @PostMapping("/post/student")
    private ResponseEntity<?> addStudent(@RequestBody Student_t studentT){
        Student_t s = new Student_t();
        s.setStudent_code( studentT.getStudent_code() );
        s.setFull_name( studentT.getFull_name() );
        s.setAddress( studentT.getAddress() );
        _iStudentRepo.save( s );
        return ResponseEntity.ok( "CREATE STUDENT OK" ) ;
    }


    @PostMapping("/post/subject")
    private ResponseEntity<?> addSubject(@RequestBody Subject_t subjectT){
        Subject_t s = new Subject_t();
        s.setSubject_name( subjectT.getSubject_name() );
        s.setCredit( subjectT.getCredit() );
        s.setSubject_code( subjectT.getSubject_code() );
        _iSubjectRepo.save( s );
        return ResponseEntity.ok( " CREATE SUBJECT OK" ) ;
    }

    @PostMapping("/post/score")
    private ResponseEntity<?> addScore(@RequestBody RequestStudentScore score){
        Student_score_t s = new Student_score_t();
        Optional<Student_t> student = _iStudentRepo.findById( score.getStudent() );
      Optional<Subject_t> subject = _iSubjectRepo.findById( score.getSubject() );

      double result = score( score.getScore1(),  score.getScore2());
        String Grade_result = null;

        if (result >= 8.0 && result <= 10) {
            Grade_result = "A";
        } else if (result >= 6.0 && result < 8.0) {
// Điều kiện cho điểm B
            Grade_result = "B";
        }else if(result >= 4.0 && result < 6.0){
            Grade_result = "D";
        }else {
            Grade_result = "F";
        }
        s.setScore1(score.getScore1() );
        s.setScore2( score.getScore2() );
        s.setSubject( subject.get() );
        s.setStudent( student.get() );
        s.setGrade( Grade_result );

        _iStudentScoreRepo.save( s );
        return ResponseEntity.ok( " CREATE SUBJECT OK" ) ;
    }

    private double score( double score1, double score2 ){
        double grade = 0;
        grade = 0.3 * score1 + 0.7 * score2;
        return grade;
    }


}
