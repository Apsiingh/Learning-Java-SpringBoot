package org.geeksforgeeks.crash_course_spring.controllers;


import jakarta.validation.Valid;
import org.geeksforgeeks.crash_course_spring.entites.Student;
import org.geeksforgeeks.crash_course_spring.exceptions.NotFoundException;
import org.geeksforgeeks.crash_course_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentContoller {

    private final StudentService studentService;

    @Autowired
    public StudentContoller(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){
        try{
            return ResponseEntity.ok(  this.studentService.addStudent(student));
        } catch (Exception e){
            return  ResponseEntity.internalServerError().body(Map.of("error" ,e.getMessage()));
        }
    }

    @GetMapping("/view/{sId}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "sId") long studentId) {
      try{
           Student student =  this.studentService.getStudentById(studentId);
//           return  ResponseEntity.ok(student);
          return new ResponseEntity<>(student, HttpStatus.OK);
      } catch (NotFoundException e){
       return  new ResponseEntity<>(Map.of("message",e.getMessage()), HttpStatus.NOT_FOUND);
      } catch (Exception e){
      return  ResponseEntity.internalServerError().body(Map.of("error" ,e.getMessage()));
      }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudentById(@RequestBody Student student) {
        if (student.getId() == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Student ID must be provided"));
        }
        try {
            Student updatedStudent = studentService.updateStudentById(student);
            return ResponseEntity.ok(updatedStudent);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }
    }
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable long studentId) {
     try{
         this.studentService.deleteStudentById(studentId);
         return ResponseEntity.ok().build();
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
     }
    }

}
