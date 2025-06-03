package org.geeksforgeeks.crash_course_spring.controllers;

import jakarta.validation.Valid;
import org.geeksforgeeks.crash_course_spring.entites.Mentor;
import org.geeksforgeeks.crash_course_spring.service.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mentor")
public class MentorControllers {
    private final MentorService mentorService;

    public MentorControllers(MentorService mentorService){
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMentor(@RequestBody @Valid Mentor mentor){
    try{
        return new ResponseEntity<>(this.mentorService.addMentor(mentor), HttpStatus.CREATED);
    } catch (Exception e) {
        return  ResponseEntity.internalServerError().body(Map.of("error" ,e.getMessage()));
    }

    }
}
