package com.restlearning.demo.rest;

import com.restlearning.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestContoller {
    List<Student>s;
    @PostConstruct
    public void loadData(){
        s=new ArrayList<>();
        s.add(new Student("Wasiq","Mirab"));
        s.add(new Student("Maida","Mirab"));

    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return s;
    }
    //for retreiving single data
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){

        if(studentID>=s.size()||studentID<0){
            throw new StudentNotFoundException("Student id not found "+studentID);
        }
        return s.get(studentID);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
